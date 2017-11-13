package com.example.login.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/download")
public class DownloadController {
    //springboot_直接コンテンツを返す(新旧),Stringでコンテンツが返る 場合,コンテンツタイプを指定する、定数のクラス名 ,@ResponseBodyと@ResponseEntityの違い
    @GetMapping
    public void oldDownload(HttpServletResponse response) throws IOException {
        response.getWriter().write("古い方法");
    }
}
