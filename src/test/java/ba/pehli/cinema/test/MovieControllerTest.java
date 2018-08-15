package ba.pehli.cinema.test;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.springframework.ui.Model;

import ba.pehli.cinema.controller.MovieController;
import ba.pehli.cinema.domain.Movie;
import ba.pehli.cinema.service.MovieDao;
import ba.pehli.cinema.service.RatingDao;
import ba.pehli.cinema.service.UserDao;

public class MovieControllerTest{
//Controller
	private MovieController movieControllerMock;
//Dao's and other classes
	private MovieDao movieDaoMock;
	private UserDao userDaoMock;
	private RatingDao ratingDaoMock;

//Models / objects
	private Model modelMock;
	
		
	@Before
	public void setupMock(){
		movieDaoMock = mock(MovieDao.class);
		userDaoMock = mock(UserDao.class);
		ratingDaoMock = mock(RatingDao.class);
		movieControllerMock = new MovieController(movieDaoMock, userDaoMock, ratingDaoMock);
		
		mock(Movie.class);
		modelMock = mock(Model.class);
		
	}
	
	
	@Test
	public void testShowPage() {
		int id = 1;
		int size = 5;

		System.out.println("Calling MovieController.showPage(" + id + ", modelMock)");
		movieControllerMock.showPage(id, modelMock);
		
		System.out.println("Verifying the order of method invocation that showPage() makes on MovieDao");
		InOrder order = inOrder(movieDaoMock, userDaoMock, ratingDaoMock);
		order.verify(userDaoMock, atLeast(1)).getAuthenticatedUser();
		order.verify(movieDaoMock).findAll(id, size);
				
	}

}