package leifeng.bs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import leifeng.bs.base.DaoSupportImpl;
import leifeng.bs.dao.RoleDao;
import leifeng.bs.domain.Role;
import leifeng.bs.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {


}
