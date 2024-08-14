package org.example.carserver.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Profile;

@Profile("feign")
@FeignClient(name = "CityManagement")
public interface PersonFeignClient extends PersonClient {


}
