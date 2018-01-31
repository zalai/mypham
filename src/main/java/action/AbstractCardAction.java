package action;

import javax.servlet.http.HttpSession;

import model.CardDto;

public abstract class AbstractCardAction {

	public CardDto getCardSession(HttpSession session) {

		return (CardDto)session.getAttribute("cardItems");
	}
}
