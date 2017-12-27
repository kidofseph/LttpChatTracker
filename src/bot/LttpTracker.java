package bot;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.jibble.pircbot.PircBot;

import backgroundutil.BackgroundUtilities;
import backgroundutil.LttpTrackerConstants;
import exceptions.ApplicationException;
import gui.LttpTrackerGui;

public class LttpTracker extends PircBot
{
	private Set<String> m_setWhitelist;
	private Set<String> m_setMods;
	private Date m_dtLastCheckedMods;
	
	public LttpTracker()
	{
		this.setName("botofseph");
		m_setWhitelist = BackgroundUtilities.readWhiteListFromFile();
		m_setMods = getMods();
		m_dtLastCheckedMods = new Date();
	}
	
	public void onMessage(String p_strChannel, String p_strSender, String p_strLogin, String p_strHostname, String p_strMessage)
	{
		if(m_dtLastCheckedMods != null)
		{
			Date dtNow = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(m_dtLastCheckedMods);
			cal.add(Calendar.MINUTE, 2);
			if(dtNow.after(cal.getTime()))
			{
				m_setMods = getMods();
			}
		}
		if(p_strMessage.startsWith("!up"))
		{
			if(m_setMods.contains(p_strSender.toUpperCase()) || m_setWhitelist.contains(p_strSender.toUpperCase()))
			{
				try
				{
					String strMessage[] = p_strMessage.split(" ");
					LttpTrackerGui gui = new LttpTrackerGui();
					gui.incrementItem(strMessage[1].toUpperCase());
				}
				catch(ApplicationException e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(p_strMessage.startsWith("!down"))
		{
			if(m_setMods.contains(p_strSender.toUpperCase()) || m_setWhitelist.contains(p_strSender.toUpperCase()))
			{
				try
				{
					String strMessage[] = p_strMessage.split(" ");
					LttpTrackerGui gui = new LttpTrackerGui();
					gui.decrementItem(strMessage[1].toUpperCase());
				}
				catch(ApplicationException e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(p_strMessage.startsWith("!set"))
		{
			if(m_setMods.contains(p_strSender.toUpperCase()) || m_setWhitelist.contains(p_strSender.toUpperCase()))
			{
				String strMessage[] = p_strMessage.split(" ");
				if(strMessage[1].toUpperCase().equals(LttpTrackerConstants.BOMBOS) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.QUAKE) || 
						strMessage[1].toUpperCase().equals(LttpTrackerConstants.ETHER))
				{
					try
					{
						LttpTrackerGui gui = new LttpTrackerGui();
						gui.setDungeon(strMessage[1].toUpperCase(), strMessage[2].toUpperCase());
					}
					catch(IndexOutOfBoundsException e)
					{
						e.printStackTrace();
					}
				}
				else if(strMessage[1].toUpperCase().equals(LttpTrackerConstants.EASTERN_PALACE) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.DESERT_PALACE) ||
						strMessage[1].toUpperCase().equals(LttpTrackerConstants.TOWER_OF_HERA) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.PALACE_OF_DARKNESS) ||
						strMessage[1].toUpperCase().equals(LttpTrackerConstants.SWAMP_PALACE) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.SKULL_WOODS) || 
						strMessage[1].toUpperCase().equals(LttpTrackerConstants.THIEVES_TOWN) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.ICE_PALACE) ||
						strMessage[1].toUpperCase().equals(LttpTrackerConstants.MISERY_MIRE) || strMessage[1].toUpperCase().equals(LttpTrackerConstants.TURTLE_ROCK))
				{
					LttpTrackerGui gui = new LttpTrackerGui();
					gui.setDungeonPrize(strMessage[1].toUpperCase(), strMessage[2].toUpperCase());
				}
			}
		}
		else if(p_strMessage.startsWith("!reset"))
		{
			if(m_setMods.contains(p_strSender.toUpperCase()) || m_setWhitelist.contains(p_strSender.toUpperCase()))
			{
				try
				{
					LttpTrackerGui gui = new LttpTrackerGui();
					gui.resetModels();
				}
				catch(IndexOutOfBoundsException e)
				{
					e.printStackTrace();
				}
			}
		}
		else if(p_strMessage.startsWith("!whitelist") && p_strChannel.equals("#" + p_strSender))
		{
			String[] strMessage = p_strMessage.toUpperCase().split(" ");
			if(strMessage[1].equals("ADD"))
			{
				BackgroundUtilities.addToWhitelist(strMessage[2].toUpperCase());
				m_setWhitelist.add(strMessage[2].toUpperCase());
			}
			else if(strMessage[1].equals("REMOVE"))
			{
				BackgroundUtilities.removeFromWhitelist(strMessage[2].toUpperCase());
				m_setWhitelist.remove(strMessage[2].toUpperCase());
			}
		}
	}
	
	public Set<String> getMods()
	{
		Set setMods = new HashSet<String>();
		String resourceURL = "http://tmi.twitch.tv/group/user/" + LttpTrackerConstants.USER + "/chatters";
		HttpGet get = new HttpGet(resourceURL);
		DefaultHttpClient client = new DefaultHttpClient();
		HttpResponse response = null;
		int code = -1;
		try
		{
			response = client.execute(get);
			code = response.getStatusLine().getStatusCode();
			if(code >= 400)
			{
				System.out.println("Could not retrieve list of mods.");
				return null;
			}
			else
			{
				return BackgroundUtilities.handleJsonResponse(response);
			}
		}
		catch(IOException e)
		{
			System.out.println("Could not retrieve list of mods.");
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			get.releaseConnection();
		}
		
		return null;
	}
}
