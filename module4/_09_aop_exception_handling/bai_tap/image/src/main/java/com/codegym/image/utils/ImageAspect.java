package com.codegym.image.utils;

import com.codegym.image.model.Image;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ImageAspect {
    Logger logger = LoggerFactory.getLogger(ImageAspect.class);
    @AfterThrowing("execution(* com.codegym.image.controller.ImageController.add(..)) && args(img,..)")
    public void checkImg(Image img){
                logger.info("{} nay ghi loi {}",img.getAuthor(), img.getFeedBack());

            }
    }
