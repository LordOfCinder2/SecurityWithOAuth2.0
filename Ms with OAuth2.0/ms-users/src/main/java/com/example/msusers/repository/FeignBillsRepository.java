package com.example.msusers.repository;

import com.example.msusers.configuration.feign.OAuthFeignConfig;
import com.example.msusers.domain.Bill;
import com.example.msusers.domain.Users;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "ms-bill", url = "http://localhost:8092/bills", configuration = OAuthFeignConfig.class)
public interface FeignBillsRepository {

    @GetMapping
    List<Bill> findById(@RequestParam String id);


}
