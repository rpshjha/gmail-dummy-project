package com.rpshjha.gmailproject.service;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: rupeshkumar
 * Date: 08/09/21
 * Time: 10:44 AM
 * To change this template use File | Settings | File and Code Templates.
 */
@Lazy
@Service
public class ScreenshotService {

    @Autowired
    private ApplicationContext ctx;

    public void takeScreenshot() throws IOException {
        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
        String methodName = new Throwable().getStackTrace()[0].getMethodName();
        String path = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + methodName + System.currentTimeMillis() + ".png";
        FileCopyUtils.copy(sourceFile, new File(path));
    }
}
