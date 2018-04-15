package gril.demo.repository;
import gril.demo.domain.Friend;
import gril.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendRepository extends  JpaRepository<Friend,Integer> {
    public List<Friend> findByName(String name);
}
