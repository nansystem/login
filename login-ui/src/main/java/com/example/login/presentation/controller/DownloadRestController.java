package com.example.login.presentation.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/download/")
public class DownloadRestController {

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public String download() {
        return "<a><b>content</b></a>";
    }

    @GetMapping("byte")
    public ResponseEntity<byte[]> byteDownload() throws UnsupportedEncodingException {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "text/csv; charset=MS932");
        httpHeaders.setContentDispositionFormData("filename", "こんにちは.csv", StandardCharsets.UTF_8);
        return new ResponseEntity<>("あ,い,う,え,お".getBytes("MS932"), httpHeaders, HttpStatus.OK);
    }

    @GetMapping(value = "build", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public FileSystemResource fileSystemResource() {
        return new FileSystemResource("build.gradle");
    }


}
