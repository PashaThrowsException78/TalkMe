package com.tabakov.talkme.client;

import com.tabakov.talkme.config.AuthFeignClientConfig;
import com.tabakov.talkme.domain.dto.program.ProgramResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "program", url = "https://api.admitad.com/advcampaigns/website", configuration = AuthFeignClientConfig.class)
public interface ProgramFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/{productId}/?limit=2")
    ProgramResponse getPrograms(@PathVariable int productId);

}
