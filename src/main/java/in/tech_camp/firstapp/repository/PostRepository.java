package in.tech_camp.firstapp.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import in.tech_camp.firstapp.entity.PostEntity;

@Mapper
public interface PostRepository {
  @Select("SELECT * FROM posts")
  List<PostEntity> findAll();

  @Insert("insert into posts (content) values (#{content})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(PostEntity post);
}
