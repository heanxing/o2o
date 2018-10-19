package com.o2o.controller.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.o2o.dto.ShopExecution;
import com.o2o.entity.PersonInfo;
import com.o2o.entity.Shop;
import com.o2o.enums.ShopStateEnum;
import com.o2o.service.ShopService;
import com.o2o.util.HttpServletRequestUtil;
import com.o2o.util.ImageUtil;
import com.o2o.util.PathUtil;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by heanxing on 2018/10/17.
 */
@Controller
@RequestMapping("/shopadmin")
public class ShopConroller {
    @Autowired
    ShopService shopService;
    @RequestMapping(value = "/ registerShop",method = RequestMethod.POST)
    private Map<String,Object> registerShop (HttpServletRequest request) {
        Map<String, Object> moderlMap = new HashMap<String, Object>();
        //1.接受并转化相应的参数，包括店铺信息以及图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            moderlMap.put("success", false);
            moderlMap.put("errMsg", e.getMessage());
            return moderlMap;
        }
        CommonsMultipartFile shopImg=null;
        CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
            shopImg = ( CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        }else{
            moderlMap.put("success", false);
            moderlMap.put("errMsg", "上传图片不能为空");
            return moderlMap;
        }
        //2.店铺注册
        if (shop !=null && shopImg != null){
            //Session TODgit
            PersonInfo owner=new PersonInfo();
            owner.setId(1L);
            shop.setOwner(owner);
            File shopImgFile=new File(PathUtil.getImageBasePath()+ ImageUtil.getRandomFileName());
            try {
                shopImgFile.createNewFile();
            } catch (IOException e) {
                moderlMap.put("success", false);
                moderlMap.put("errMsg", e.getMessage());
                return moderlMap;
            }
            try {
                inputStreamToFile(shopImg.getInputStream(),shopImgFile);
            } catch (IOException e) {
                moderlMap.put("success", false);
                moderlMap.put("errMsg", e.getMessage());
                return moderlMap;
            }
            ShopExecution se=shopService.addShop(shop,shopImgFile);
            if (se.getState()==ShopStateEnum.CHECK.getState()){
                moderlMap.put("success", true);
            }else {
                moderlMap.put("success", false);
                moderlMap.put("errMsg",se.getStateInfo());
            }
            return moderlMap;
        }else {
            moderlMap.put("success", false);
            moderlMap.put("errMsg", "请输入店铺信息");
            return moderlMap;
        }


    }
    private static  void  inputStreamToFile(InputStream ins,File file){
        FileOutputStream os= null;
        try {
            os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer=new byte[1024];
            while ((bytesRead=ins.read(buffer)) != -1){
                os.write(buffer,0,bytesRead);

            }
        }catch (Exception e){
            throw new  RuntimeException("调用inputStreamTofile产生异常:"+ e.getMessage());
        }finally {
            try {
                if (os != null){
                    os.close();
                }
                if (ins !=null){
                    ins.close();
                }
            }catch (IOException e){
                throw new  RuntimeException("inputStreamTofile关闭异常:"+ e.getMessage());
            }
        }
    }




}
