package org.example.citymanagement.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

@Profile("feign")
@FeignClient(name = "CarServer")
public interface CarFeignClient extends CarClient {

}
