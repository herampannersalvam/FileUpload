package com.app.fileupload.service;



import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.fileupload.entity.FileUpload;
import com.app.fileupload.repository.FileRepository;

@Service
public class FileService {

	@Autowired
	FileRepository fileRepository;

	private static String folderName;
	
	private final static String File_Sava="C:\\Users\\heram\\Ram\\fileupload"+folderName;
	
	public String uploadfile(MultipartFile file) throws IllegalStateException, IOException {
		
		String filePath=File_Sava + file.getOriginalFilename();
		
		FileUpload fileData=fileRepository.save(FileUpload.builder()
				.fileName(file.getOriginalFilename())
				.fileType(file.getContentType())
				.filePath(filePath)
				.build());
		file.transferTo(new File(filePath));
		
		if(filePath !=null) {
			return "File Upload Successfully"+filePath;
		}
		return null;
		
	}

	public byte[] getfile(String fileName) throws IOException {
		Optional<FileUpload> fileData=fileRepository.findByfileName(fileName);
		String filePath=fileData.get().getFilePath();
		byte[] images = Files.readAllBytes(new File(filePath).toPath());
		return images;
	}				
						
		
}
