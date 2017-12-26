package bookmanager.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import bookmanager.inf.IMember;
import bookmanager.model.ModelMember;

@Repository("daomember")
public class DaoMember implements IMember {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public List<ModelMember> selectAll() throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectAll");
        return rs;
    }

    @Override
    public List<ModelMember> selectLike(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectLike", member);
        return rs;
    }

    @Override
    public List<ModelMember> selectEqual(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectEqual", member);
        return rs;
    }

    @Override
    public List<ModelMember> selectDynamic(ModelMember member)
            throws SQLException {
        List<ModelMember> rs = null;
        rs = session.selectList("mapper.mapperMember.selectDynamic", member);
        return rs;
    }

    @Override
    public int insertMember(ModelMember member) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperMember.insertMember", member);
        return rs;
    }

    @Override
    public int updateMember(ModelMember wheremember, ModelMember setmemeber)
            throws SQLException {
        int rs = -1;
        Map<String, ModelMember> map = new HashMap<>();
        map.put("wheremember", wheremember);
        map.put("setmemeber", setmemeber);
        rs = session.insert("mapper.mapperMember.updateMember", map);
        return rs;
    }

    @Override
    public int deleteMember(ModelMember member) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperMember.deleteMember", member);
        return rs;
    }
}
