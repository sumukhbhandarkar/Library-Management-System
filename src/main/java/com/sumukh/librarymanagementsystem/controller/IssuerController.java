package com.sumukh.librarymanagementsystem.controller;

import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import com.sumukh.librarymanagementsystem.utils.APIPaths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class IssuerController {
    private static final Logger logger = LoggerFactory.getLogger(IssuerController.class);
    @RequestMapping(value = APIPaths.ADD_BORROWER, method = RequestMethod.POST, consumes = { "application/JSON" })
    public ResponseEntity<String> addBorrower(@RequestBody @Valid IssuerEntity issuerEntity) {
        logger.info("adding borrower");
        URI location = URI.create(APIPaths.ADD_BORROWER + issuerEntity.getIssuerID());
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setLocation(location);
        return new ResponseEntity<String>("Created", responseHeaders, HttpStatus.CREATED);
    }
}
