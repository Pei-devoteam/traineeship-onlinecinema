package ba.pehli.cinema.test;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.junit.Before;

import ba.pehli.cinema.service.UserDao;
import ba.pehli.cinema.domain.User;
import ba.pehli.cinema.domain.Movie;
import ba.pehli.cinema.utils.EmailUtils;
import ba.pehli.cinema.controller.UsersController;

import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.test.web.servlet.MockMvc;

public class UserTest{
	
//Controller
	private UsersController usersControllerMock;
//Dao's and other classes
	private MessageSource messageSourceMock;
	private EmailUtils emailUtilsMock;
	private UserDao userDaoMock;
	private User testyMcTest;
//models / objects
	private Model modelMock;
	private Movie movieMock;
	private User userMock;
//Else
	private MockMvc mockMvc;
	
	
	@Before
	public void setupMock(){
		setUserDaoMock(mock(UserDao.class));
		setUsersControllerMock(new UsersController());
		setMovieMock(mock(Movie.class));
		setModelMock(mock(Model.class));
		setUserMock(mock(User.class));
		testyMcTest = new User();
	}
	
	@Test
	public void testSetId() throws Exception {
		testyMcTest = new User();
		testyMcTest.setId(11);
		assertTrue(testyMcTest.getId() == 11);
	}
	
	@Test
	public void testSetUsername() throws Exception {
		testyMcTest = new User();
		testyMcTest.setUsername("ismail");
		assertTrue(testyMcTest.getUsername() == "ismail");
	}
	
	@Test
	public void testSetPassword() throws Exception {
		testyMcTest = new User();
		testyMcTest.setPassword("ismail123");
		assertTrue(testyMcTest.getPassword() == "ismail123");
	}
	
	@Test
	public void testSetRole() throws Exception {
		testyMcTest = new User();
		testyMcTest.setRole("tester1");
		assertTrue(testyMcTest.getRole() == "tester1");
	}
	
	@Test
	public void testSetCountry() throws Exception {
		testyMcTest = new User();
		testyMcTest.setCountry("United Kingdom");
		assertTrue(testyMcTest.getCountry() == "United Kingdom");
	}
	
	@Test
	public void testSetVerificationCode() throws Exception {
		testyMcTest = new User();
		testyMcTest.setVerificationCode("123456");
		assertTrue(testyMcTest.getVerificationCode() == "123456");
	}
	
	@Test
	public void testIsEnabled() throws Exception {
		testyMcTest = new User();
		testyMcTest.setEnabled(true);
		assertTrue(testyMcTest.isEnabled());
	}

	public UsersController getUsersControllerMock() {
		return usersControllerMock;
	}

	public void setUsersControllerMock(UsersController usersControllerMock) {
		this.usersControllerMock = usersControllerMock;
	}

	public MessageSource getMessageSourceMock() {
		return messageSourceMock;
	}

	public void setMessageSourceMock(MessageSource messageSourceMock) {
		this.messageSourceMock = messageSourceMock;
	}

	public EmailUtils getEmailUtilsMock() {
		return emailUtilsMock;
	}

	public void setEmailUtilsMock(EmailUtils emailUtilsMock) {
		this.emailUtilsMock = emailUtilsMock;
	}

	public UserDao getUserDaoMock() {
		return userDaoMock;
	}

	public void setUserDaoMock(UserDao userDaoMock) {
		this.userDaoMock = userDaoMock;
	}

	public Model getModelMock() {
		return modelMock;
	}

	public void setModelMock(Model modelMock) {
		this.modelMock = modelMock;
	}

	public Movie getMovieMock() {
		return movieMock;
	}

	public void setMovieMock(Movie movieMock) {
		this.movieMock = movieMock;
	}

	public User getUserMock() {
		return userMock;
	}

	public void setUserMock(User userMock) {
		this.userMock = userMock;
	}

	public MockMvc getMockMvc() {
		return mockMvc;
	}

	public void setMockMvc(MockMvc mockMvc) {
		this.mockMvc = mockMvc;
	}
		
	
}