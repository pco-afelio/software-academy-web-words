package be.afelio.pco.web.words;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordGameServlet extends HttpServlet {

	private EnigmaCreator enigmaCreator; // = new EnigmaCreator(5);

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		int length = 4;
		String lengthAsString = config.getInitParameter("minWordLength");
		if (lengthAsString != null) {
			try {
				length = Integer.parseInt(lengthAsString);
			} catch(NumberFormatException e) {}
		}
		enigmaCreator = new EnigmaCreator(length);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("WordGameServlet.doGet()");
		
		Enigma enigma = enigmaCreator.createEnigma();
		System.out.println(enigma);
		
		req.getSession().setAttribute("savedEnigma", enigma);
		req.setAttribute("generatedEnigma", enigma);
		req.getRequestDispatcher("/enigma.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		System.out.println("WordGameServlet.doPost()");
		Enigma enigma = (Enigma) req.getSession().getAttribute("savedEnigma");
		if (enigma != null) {
			String proposition = req.getParameter("word");
			if (proposition != null) {
				enigmaCreator.checkWord(enigma, proposition);
			}
			@SuppressWarnings("unchecked")
			List<Enigma> history = 
					(List<Enigma>) req.getSession().getAttribute("savedHistory");
			if (history == null) {
				history = new ArrayList<>();
				req.getSession().setAttribute("savedHistory", history);
			}
			history.add(enigma);
			
			req.setAttribute("enigma", enigma);
			req.setAttribute("history", history);
			req.getRequestDispatcher("/result.jsp").forward(req, resp);
		} else {
			doGet(req, resp);
		}
		
	}
	
	
}






