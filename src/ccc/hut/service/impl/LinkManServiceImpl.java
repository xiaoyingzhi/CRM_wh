package ccc.hut.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import ccc.hut.dao.ILinkManDao;
import ccc.hut.domain.LinkMan;
import ccc.hut.service.ILinkManService;

/**
 * 联系人的业务层实现类
 * @author zhy
 *
 */
@Service("linkmanService")
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class LinkManServiceImpl implements ILinkManService {

	@Resource(name="linkmanDao")
	private ILinkManDao linkmanDao;
	
	@Override
	public void saveLinkMan(LinkMan linkman) {
		linkmanDao.save(linkman);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<LinkMan> findAllLinkMan(DetachedCriteria dCriteria) {
		return linkmanDao.findAll(dCriteria);
	}

	@Override
	public void removeLinkMan(Long lkmId) {
		linkmanDao.delete(lkmId);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public LinkMan findLinkManById(Long lkmId) {
		return linkmanDao.findById(lkmId);
	}

	@Override
	public void updateLinkMan(LinkMan linkman) {
		linkmanDao.update(linkman);
	}

}
