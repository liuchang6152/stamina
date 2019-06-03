package com.stamina.stamina.dao.pft;

import com.stamina.stamina.pojo.pft.ProjectFormPojo;
import com.stamina.stamina.pojo.pft.ScoreConfigurePojo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 模块编号：ProjectFormRepository
 *
 * @author: weijian.hou
 * 创建时间：2019-5-29
 * 修改编号：1
 * 描    述：项目清单配置
 */
public interface ScoreConfigureRepository  extends JpaRepository<ScoreConfigurePojo, Long> {

    List<ScoreConfigurePojo> findByprojectFormId(Long projectformId);

}
