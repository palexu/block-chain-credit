package top.palexu.blockchaincredit.credit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.palexu.blockchaincredit.credit.dao.ProviderBiztypeRelationMapper;
import top.palexu.blockchaincredit.credit.dao.ProviderDoMapper;
import top.palexu.blockchaincredit.credit.model.ProviderBiztypeRelation;
import top.palexu.blockchaincredit.credit.service.ProviderService;
import top.palexu.blockchaincredit.credit.vo.DataProvider;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    ProviderBiztypeRelationMapper providerBiztypeRelationMapper;

    @Autowired
    ProviderDoMapper providerDoMapper;

    @Override
    public List<DataProvider> getDataProviderList(String bizType) {
        List<DataProvider> providers = new ArrayList<>();
        List<ProviderBiztypeRelation> relations = providerBiztypeRelationMapper.selectByBizType(bizType);

        for (ProviderBiztypeRelation r : relations) {
            DataProvider provider = new DataProvider();
            providers.add(provider);

            provider.setName(r.getPname());
            provider.setPrice(r.getPrice());
            provider.setCount(r.getCount());
        }

        return providers;
    }
}
