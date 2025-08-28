package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Utils;

public class Trendingsong {
	
	public WebDriver ldriver;
	public Utils utils;
public Trendingsong(WebDriver rdriver)
{
	ldriver = rdriver;
	PageFactory.initElements(rdriver, this);
	utils = new Utils(rdriver);
	
}
@FindBy (xpath = "//h3[@class='c-title  a-font-basic u-letter-spacing-0010 u-max-width-397 lrv-u-font-size-16 lrv-u-font-size-14@mobile-max u-line-height-22px u-word-spacing-0063 u-line-height-normal@mobile-max a-truncate-ellipsis-2line lrv-u-margin-b-025 lrv-u-margin-b-00@mobile-max']")
public List<WebElement> songs_list;


@FindBy(xpath="//span[@title='News/perhour']")
public WebElement whts_grp;

@FindBy(xpath="//div[@aria-label='Type a message']")
public WebElement snd_msg;



public List<String> getSongs()
{
	utils.waitForElementsVisible(songs_list);
	List<String> song_info = new ArrayList<>();
	
	for(int i=0;i<songs_list.size();i++)
	{
		String song_title= songs_list.get(i).getText();
	String formatted_songs = (i+1)+"."+ song_title + "\n"; 
	song_info.add(formatted_songs);
	}
	return song_info;
	
}
public String convertToString()
{
	List<String> songs_title =getSongs();
	
	StringBuilder sb = new StringBuilder();
	for(String s_titles : songs_title)
	{
		sb.append(s_titles).append("\n");
	}
	return sb.toString();

}
public void sendToGroup(String text) throws InterruptedException
{
	utils.waitForVisibility(whts_grp);
	utils.click(whts_grp);
	String Songs_info = "Dear Subsrcriber,\n \n"+
	"Please find the top 10 trending song in India"+
			"\n \n"+
	text+
	
	"Regards \n"+
	"Prasoon Saurav"+"\n" +
	"Source: https://www.billboard.com/";
	
	utils.sendKeysWithMouse(snd_msg, Songs_info);
	
}
}


