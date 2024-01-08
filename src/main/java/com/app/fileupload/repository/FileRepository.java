package com.app.fileupload.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.fileupload.entity.FileUpload;

@Repository
public interface FileRepository  extends JpaRepository<FileUpload,UUID>{

	Optional<FileUpload> findByfileName(String fileName);

	

	

}
