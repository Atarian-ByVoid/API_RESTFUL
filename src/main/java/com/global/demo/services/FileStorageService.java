package com.global.demo.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.global.demo.config.FileStorageConfig;
import com.global.demo.exceptions.FileStorageException;

@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService(FileStorageConfig FileStorageConfig) {

        Path path = Paths.get(FileStorageConfig.getUploadDir())
                .toAbsolutePath().normalize();

        this.fileStorageLocation = path;

        try {
            Files.createDirectories(this.fileStorageLocation);

        } catch (Exception e) {

            throw new FileStorageException("Could not create the director where the uploaded files will be stored!", e);
        }

    }

    public String storeFile(MultipartFile file){
        String filename="";

        try {
            
        } catch (Exception e) {
            throw new FileStorageException("Could not be store file"+filename+".Please try again",e);
        }
    }

}
