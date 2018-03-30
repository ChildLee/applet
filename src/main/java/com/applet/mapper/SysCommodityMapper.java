package com.applet.mapper;

import com.applet.entity.SysCommodity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysCommodityMapper {

    Boolean createCommodity(SysCommodity commodity);

    Boolean deleteCommodity(SysCommodity commodity);

    Boolean updateCommodity(SysCommodity commodity);

    List<SysCommodity> getCommodity();
}
