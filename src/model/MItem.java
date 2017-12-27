package model;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import backgroundutil.LttpTrackerConstants;

public class MItem
{
	private String m_strName;
	private ArrayList<ImageIcon> m_listIcons;
	private int m_iCurrentIcon = 0;
	private Date m_dtLastUpdated;
	
	public String getName()
	{
		return m_strName;
	}
	
	public void setName(String p_strName)
	{
		m_strName = p_strName;
	}
	
	public ArrayList<ImageIcon> getIcons()
	{
		return m_listIcons;
	}
	
	public void addImage(ImageIcon p_image, int p_iNumber)
	{
		if(m_listIcons == null)
		{
			m_listIcons = new ArrayList<>();
		}
		
		m_listIcons.add(p_iNumber, p_image);
	}
	
	public void incrementImage()
	{
		if(m_iCurrentIcon == m_listIcons.size()-1)
		{
			
		}
		else
		{
			m_iCurrentIcon++;
		}
	}
	
	public void decrementImage()
	{
		if(m_iCurrentIcon == 0)
		{
			
		}
		else
		{
			--m_iCurrentIcon;
		}
	}
	
	public ImageIcon getGrayImage()
	{
		return m_listIcons.get(0);
	}
	
	public ImageIcon getCurrentIcon()
	{
		return m_listIcons.get(m_iCurrentIcon);
	}

	public Date getLastUpdated()
	{
		return m_dtLastUpdated;
	}

	public void setLastUpdated(Date p_dtLastUpdated)
	{
		m_dtLastUpdated = p_dtLastUpdated;
	}
	
	public void setDungeonPrize(String p_strPrize)
	{
		if(p_strPrize.equals(LttpTrackerConstants.CRYSTAL))
		{
			m_iCurrentIcon = 0;
		}
		else if(p_strPrize.equals(LttpTrackerConstants.PENDANT))
		{
			m_iCurrentIcon = 2;
		}
		else if(p_strPrize.equals(LttpTrackerConstants.PENDANT_PLUS))
		{
			m_iCurrentIcon = 4;
		}
		else if(p_strPrize.equals(LttpTrackerConstants.CRYSTAL_PLUS))
		{
			m_iCurrentIcon = 6;
		}
	}
	
	public void setDungeonRequirement(String p_strDungeon)
	{
		if(p_strDungeon.equals(LttpTrackerConstants.MM))
		{
			if(isLit())
			{
				m_iCurrentIcon = 3;
			}
			else
			{
				m_iCurrentIcon = 2;
			}
		}
		else if(p_strDungeon.equals(LttpTrackerConstants.TR))
		{
			if(isLit())
			{
				m_iCurrentIcon = 5;
			}
			else
			{
				m_iCurrentIcon = 4;
			}
		}
		else if(p_strDungeon.equals(LttpTrackerConstants.MED_2))
		{
			if(isLit())
			{
				m_iCurrentIcon = 7;
			}
			else
			{
				m_iCurrentIcon = 6;
			}
		}
	}
	
	public boolean isLit()
	{
		if(m_iCurrentIcon == 1 || m_iCurrentIcon == 3 || m_iCurrentIcon == 5 || m_iCurrentIcon == 7)
		{
			return true;
		}
		return false;
	}
	
	public void resetIcon()
	{
		m_iCurrentIcon = 0;
	}
}
