package com.example.login.presentation.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RestController
@RequestMapping("/download")
public class DownloadController {
    //    springboot_ダウンロードステップ3,ダウンロードはメモリのまま出力するか一時ファイルを経由するか,ダウンロードする際のヘッダー2,application/octet-streamの意味とブラウザの挙動,ダウンロード時のデフォルトのファイル名指定2,Javaのエンコードで気をつけること2と対応方法,byte[]でSHIFT-JISのCSVファイルをダウンロード,pom.xmlをダウンロード,Resourceを実装しているよく使うクラス5,InputStreamResourceでダウンロード
    //    springboot_直接コンテンツを返す(新旧),Stringでコンテンツが返る 場合,コンテンツタイプを指定する、定数のクラス名 ,@ResponseBodyと@ResponseEntityの違い

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public String fileToByte(HttpServletResponse response) throws IOException {
        try (
                BufferedWriter bw = Files.newBufferedWriter(Paths.get("/Users/nanya/git/me/login/src/main/java/com/example/login/presentation/controller/char.txt"), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        ) {
            bw.write("1行目ですかね");
            bw.newLine();
            bw.write("2行目ですかね");
            bw.newLine();
        }catch (IOException e) {
            e.printStackTrace();
        }

        response.setCharacterEncoding("UTF-8");
        //filename*=UTF-8''" + UriUtils.encode("すーぱー", StandardCharsets.UTF_8.name()) +".txt"
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachement;filename=すーぱー日本語.txt");
        try {
            Path path = Paths.get("/Users/nanya/git/me/login/src/main/java/com/example/login/presentation/controller/char.txt");
            Files.copy(path, response.getOutputStream());
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
