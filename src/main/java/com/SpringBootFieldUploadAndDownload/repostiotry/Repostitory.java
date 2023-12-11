package com.SpringBootFieldUploadAndDownload.repostiotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBootFieldUploadAndDownload.entity.Empentity;

public interface Repostitory extends JpaRepository<Empentity, Integer> {

}
