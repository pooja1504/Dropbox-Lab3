package com.javasampleapproach.jpaunittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.javasampleapproach.jpaunittest.entity.User;
import com.javasampleapproach.jpaunittest.entity.Mappings;
import com.javasampleapproach.jpaunittest.entity.Contents;
import com.javasampleapproach.jpaunittest.repo.UserRepository;

@RunWith(SpringRunner.class)
public class ApplicationTestCases {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	UserRepository userrepository;
	MappingRepository mappingrepository;
	ContentRepository contentrepository;

	@Test
	public void should_find_no_user_if_list_is_empty() {
		Iterable<Users> users = userrepository.findAll();

		assertThat(users).isEmpty();
	}

	@Test
	public void store_user() {
		User user = userrepository.save(new User("pooja@gmail.com","Pooja", "Patel"));
		assertThat(user).hasFieldOrPropertyWithValue("email", "pooja@gmail.com");
	}

	@Test
	public void should_delete_all_users() {
		entityManager.persist(new User("Pooja", "Patel"));
		entityManager.persist(new User("xyz", "xyz"));
		userrepository.deleteAll();
		assertThat(userrepository.findAll()).isEmpty();
	}

	@Test
	public void should_find_all_users() {
		User User1 = new User("Pooja", "Patel");
		entityManager.persist(User1);

		User User2 = new User("xyz", "xyz");
		entityManager.persist(User2);

		User User3 = new User("abc", "abc");
		entityManager.persist(User3);

		Iterable<User> Users = userrepository.findAll();

		assertThat(Users).hasSize(3).contains(User1, User2, User3);
	}

	@Test
	public void should_find_User_by_email() {
		User User1 = new User("Pooja", "Patel");
		entityManager.persist(User1);

		User User2 = new User("xyz", "xyz");
		entityManager.persist(User2);

		User foundUser = userrepository.findOne(User2.getemail());

		assertThat(foundUser).isEqualTo(User2);
	}

	@Test
	public void should_find_no_files_if_userfiles_is_empty() {
		Iterable<Files> files = contentrepository.findAllByUserid();
		assertThat(files).isEmpty();
	}
	@Test
	public void should_find_files_by_useremail() {
		User User1 = new User("pooja@gmail.com");
		entityManager.persist(User1);

		User foundFiles = contentrepository.findOne(User2);

		assertThat(foundFiles).isEqualTo(User1);
	}
	@Test
	public void store_files() {
		Files file= contentrepository.save(new Files("smartclass.png","pooja@gmail.com", "12/10/2017"));
		assertThat(file).hasFieldOrPropertyWithValue("smartclass.png","pooja@gmail.com");
	}
	@Test
	public void should_delete_all_files() {
		entityManager.persist(new Files("pooja@gmail.com"));
		contentrepository.deleteAll();
		assertThat(contentrepository.findAll()).isEmpty();
	}


}
