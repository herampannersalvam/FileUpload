package com.app.fileupload.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.fileupload.service.FileService;

@RestController
@RequestMapping("/files")
public class FileController {
	
	@Autowired
	FileService fileService;

	@PostMapping("/upload")
	public ResponseEntity<?>uploadfile(@RequestParam("image") MultipartFile file) throws IllegalStateException, IOException{
		String uploadImage=fileService.uploadfile(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
		
	}
	@GetMapping("/getfile/{fileName}")
	public ResponseEntity<?>getfile(@PathVariable ("fileName") String fileName) throws IOException{
		byte[] filedata=fileService.getfile(fileName);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(filedata);
	}
	
	
}
