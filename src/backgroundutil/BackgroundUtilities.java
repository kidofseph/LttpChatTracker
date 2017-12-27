package backgroundutil;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BackgroundUtilities
{
	
	private static int TRANSPARENT_COLOR = Color.MAGENTA.getRGB() | 0xFF000000;
//	private static int TRANSPARENT_COLOR2 = new Color(222, 222, 222).getRGB() | 0xFF000000;
	private static int TRANSPARENT_COLOR2 = -986896;

	public static Set<String> handleJsonResponse(HttpResponse response)
	{
		Map<String, String> oauthLoginResponse = null;
		String contentType = response.getEntity().getContentType().getValue();
		try
		{
			oauthLoginResponse = (Map<String, String>) new JSONParser()
					.parse(EntityUtils.toString(response.getEntity()));
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		catch (org.json.simple.parser.ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		catch (RuntimeException e)
		{
			System.out.println("Could not parse JSON response");
			throw e;
		}
		System.out.println();
		System.out.println("********** Response Received **********");
		JSONObject jsonObject = new JSONObject(oauthLoginResponse);
		for (Map.Entry<String, String> entry : oauthLoginResponse.entrySet())
		{
			System.out.println(String.format("TEST  %s = %s", entry.getKey(), entry.getValue()));
			if (entry.getKey().equals("chatters"))
			{
				Set<String> setMods = new HashSet<String>();
				String strChatters = String.valueOf(entry.getValue()).toUpperCase();
				int index = strChatters.indexOf("MODERATORS\":") + 13;
				String strMods = strChatters.substring(index);
				strMods = strMods.replace("\"", "");
				strMods = strMods.replace("]", "");
				strMods = strMods.replace("}", "");
				System.out.println("Mods quotes stripped: " + strMods);

				String[] strarrMods = strMods.split(",");
				for (String strMod : strarrMods)
				{
					setMods.add(strMod);
				}

				return setMods;

			}

		}
		return null;
	}

	private static ImageIcon getGray(ImageIcon icon)
	{
		final int w = icon.getIconWidth();
		final int h = icon.getIconHeight();
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		GraphicsConfiguration gc = gd.getDefaultConfiguration();
		BufferedImage image = gc.createCompatibleImage(w, h);
		Graphics2D g2d = image.createGraphics();
		g2d.setPaint(new Color(0x00f0f0f0));
		g2d.fillRect(0, 0, w, h);
		icon.paintIcon(null, g2d, 0, 0);
		BufferedImage gray = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
		ColorConvertOp op = new ColorConvertOp(image.getColorModel().getColorSpace(),
				gray.getColorModel().getColorSpace(), null);
		op.filter(image, gray);
		return new ImageIcon(gray);
	}

	public static ImageIcon getIcon(String p_strItem, boolean p_bGray)
	{
		BufferedImage biItem = null;
		ImageFilter filter = new RGBImageFilter()
		{
			
			@Override
			public final int filterRGB(int x, int y, int rgb) {
		        if ( ( rgb | 0xFF000000 ) == TRANSPARENT_COLOR  || ( rgb | 0xFF000000 ) == TRANSPARENT_COLOR2 ) {
		          // Mark the alpha bits as zero - transparent
		          return 0x00FFFFFF & rgb;
		          }
		        else {
		          // nothing to do
		          return rgb;
		          }
		        }
		};
		

		try
		{
			URL url = null;
			if (p_strItem.equals(LttpTrackerConstants.BOW1))
			{
				url = BackgroundUtilities.class.getResource("/images/0000.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOW2))
			{
				url = BackgroundUtilities.class.getResource("/images/0048.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SILVER_ARROW))
			{
				url = BackgroundUtilities.class.getResource("/images/0149.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOW3))
			{
				url = BackgroundUtilities.class.getResource("/images/0049.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MUSHROOM))
			{
				url = BackgroundUtilities.class.getResource("/images/0004.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MUSHROOM_USED))
			{
				url = BackgroundUtilities.class.getResource("/images/0056.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.HAMMER))
			{
				url = BackgroundUtilities.class.getResource("/images/0011.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.HOOKSHOT))
			{
				url = BackgroundUtilities.class.getResource("/images/0002.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.FIRE_ROD))
			{
				url = BackgroundUtilities.class.getResource("/images/0005.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.LANTERN))
			{
				url = BackgroundUtilities.class.getResource("/images/0010.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SOMARIA))
			{
				url = BackgroundUtilities.class.getResource("/images/0015.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWORD))
			{
				url = BackgroundUtilities.class.getResource("/images/0223.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWORD1))
			{
				url = BackgroundUtilities.class.getResource("/images/0023.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWORD2))
			{
				url = BackgroundUtilities.class.getResource("/images/0038.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWORD3))
			{
				url = BackgroundUtilities.class.getResource("/images/0039.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWORD4))
			{
				url = BackgroundUtilities.class.getResource("/images/0040.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SHIELD1))
			{
				url = BackgroundUtilities.class.getResource("/images/0024.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SHIELD2))
			{
				url = BackgroundUtilities.class.getResource("/images/0044.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SHIELD3))
			{
				url = BackgroundUtilities.class.getResource("/images/0045.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TUNIC1))
			{
				url = BackgroundUtilities.class.getResource("/images/0025.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TUNIC2))
			{
				url = BackgroundUtilities.class.getResource("/images/0041.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TUNIC3))
			{
				url = BackgroundUtilities.class.getResource("/images/0042.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE))
			{
				url = BackgroundUtilities.class.getResource("/images/0201.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE1))
			{
				url = BackgroundUtilities.class.getResource("/images/0070.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE2))
			{
				url = BackgroundUtilities.class.getResource("/images/0071.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE3))
			{
				url = BackgroundUtilities.class.getResource("/images/0072.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE4))
			{
				url = BackgroundUtilities.class.getResource("/images/0073.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE_RED))
			{
				url = BackgroundUtilities.class.getResource("/images/0050.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE_BLUE))
			{
				url = BackgroundUtilities.class.getResource("/images/0052.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE_GREEN))
			{
				url = BackgroundUtilities.class.getResource("/images/0051.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOTTLE_FAIRY))
			{
				url = BackgroundUtilities.class.getResource("/images/0053.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.NET))
			{
				url = BackgroundUtilities.class.getResource("/images/0013.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BYRNA))
			{
				url = BackgroundUtilities.class.getResource("/images/0016.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOOMERANG1))
			{
				url = BackgroundUtilities.class.getResource("/images/0001.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOOMERANG2))
			{
				url = BackgroundUtilities.class.getResource("/images/0037.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOOK))
			{
				url = BackgroundUtilities.class.getResource("/images/0014.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SHOVEL))
			{
				url = BackgroundUtilities.class.getResource("/images/0012.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SHOVEL_USED))
			{
				url = BackgroundUtilities.class.getResource("/images/0057.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.FLUTE))
			{
				url = BackgroundUtilities.class.getResource("/images/0047.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ICE_ROD))
			{
				url = BackgroundUtilities.class.getResource("/images/0006.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.POWDER))
			{
				url = BackgroundUtilities.class.getResource("/images/0046.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.POWDER_USED))
			{
				url = BackgroundUtilities.class.getResource("/images/0200.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.CAPE))
			{
				url = BackgroundUtilities.class.getResource("/images/0017.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.FLIPPERS))
			{
				url = BackgroundUtilities.class.getResource("/images/0021.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOOTS))
			{
				url = BackgroundUtilities.class.getResource("/images/0020.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.GLOVE1))
			{
				url = BackgroundUtilities.class.getResource("/images/0019.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.GLOVE2))
			{
				url = BackgroundUtilities.class.getResource("/images/0043.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOMBOS))
			{
				url = BackgroundUtilities.class.getResource("/images/0007.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOMBOS_MM))
			{
				url = BackgroundUtilities.class.getResource("/images/0117.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOMBOS_TR))
			{
				url = BackgroundUtilities.class.getResource("/images/0120.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.BOMBOS_2))
			{
				url = BackgroundUtilities.class.getResource("/images/0123.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ETHER))
			{
				url = BackgroundUtilities.class.getResource("/images/0008.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ETHER_MM))
			{
				url = BackgroundUtilities.class.getResource("/images/0118.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ETHER_TR))
			{
				url = BackgroundUtilities.class.getResource("/images/0121.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ETHER_2))
			{
				url = BackgroundUtilities.class.getResource("/images/0124.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.QUAKE))
			{
				url = BackgroundUtilities.class.getResource("/images/0009.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.QUAKE_MM))
			{
				url = BackgroundUtilities.class.getResource("/images/0119.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.QUAKE_TR))
			{
				url = BackgroundUtilities.class.getResource("/images/0122.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.QUAKE_2))
			{
				url = BackgroundUtilities.class.getResource("/images/0125.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0105.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0107.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0108.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0106_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.DESERT_PALACE_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0109.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.DESERT_PALACE_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0111.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.DESERT_PALACE_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0112.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.DESERT_PALACE_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0110_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0113.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0115.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0116.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0114_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0077.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0079.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0080.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0078_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0081.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0083.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0084.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0082_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SKULL_WOODS_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0085.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SKULL_WOODS_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0087.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SKULL_WOODS_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0088.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.SKULL_WOODS_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0086_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0089.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0091.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0092.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0090_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ICE_PALACE_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0093.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ICE_PALACE_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0095.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ICE_PALACE_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0096.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.ICE_PALACE_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0094_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MISERY_MIRE_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0097.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MISERY_MIRE_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0099.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MISERY_MIRE_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0100.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MISERY_MIRE_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0098_red.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL))
			{
				url = BackgroundUtilities.class.getResource("/images/0101.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK_PENDANT))
			{
				url = BackgroundUtilities.class.getResource("/images/0103.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK_PENDANT_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0104.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL_PLUS))
			{
				url = BackgroundUtilities.class.getResource("/images/0102_red.png");
			}
//			else if (p_strItem.equals(LttpTrackerConstants.PENDANT_COURAGE))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0027.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.PENDANT_POWER))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0028.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.PENDANT_WISDOM))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0029.png");
//			}
			else if (p_strItem.equals(LttpTrackerConstants.MOON_PEARL))
			{
				url = BackgroundUtilities.class.getResource("/images/0022.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.MIRROR))
			{
				url = BackgroundUtilities.class.getResource("/images/0018.png");
			}
			else if (p_strItem.equals(LttpTrackerConstants.AGAHNIM))
			{
				url = BackgroundUtilities.class.getResource("/images/0055.png");
			}
//			else if (p_strItem.equals(LttpTrackerConstants.EP_PENDANT))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0107.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL1))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0031.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL2))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0034.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL3))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0036.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL4))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0035.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL5))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0032.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL6))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0030.png");
//			}
//			else if (p_strItem.equals(LttpTrackerConstants.CRYSTAL7))
//			{
//				url = BackgroundUtilities.class.getResource("/images/0033.png");
//			}
			
			if(url != null)
			{
				biItem = ImageIO.read(url);
			}
			else
			{
				System.out.println("Invalid item: " + p_strItem);
			}
			
			ImageProducer ip = new FilteredImageSource(biItem.getSource(), filter);
			
			if(!p_bGray)
			{
				return new ImageIcon(Toolkit.getDefaultToolkit().createImage(ip));
			}
			else
			{
				ImageIcon i = new ImageIcon(Toolkit.getDefaultToolkit().createImage(ip));
				ImageIcon iGray = getGray(i);
				BufferedImage biGray = (BufferedImage) iGray.getImage();
				ImageProducer ipGray = new FilteredImageSource(biGray.getSource(), filter);
				return new ImageIcon(Toolkit.getDefaultToolkit().createImage(ipGray));
				
			}
		}
		catch (IOException e)
		{
			System.out.println("Uh oh");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void addToWhitelist(String p_strName)
	{
		FileWriter fwWhitelist = null;
		BufferedWriter bwWhitelist = null;
		PrintWriter pwWhitelist = null;
		
		try
		{
			fwWhitelist = new FileWriter(LttpTrackerConstants.WHITELIST, true);
			bwWhitelist = new BufferedWriter(fwWhitelist);
			pwWhitelist = new PrintWriter(bwWhitelist);
			
			pwWhitelist.println(p_strName);
			pwWhitelist.close();
		}
		catch(IOException e)
		{
			
		}
		finally
		{
			if(fwWhitelist != null)
			{
				try
				{
					fwWhitelist.close();
				}
				catch(IOException e)
				{
					
				}
			}
			
			if(bwWhitelist != null)
			{
				try
				{
					bwWhitelist.close();
				}
				catch(IOException e)
				{
					
				}
			}
			
			if(pwWhitelist != null)
			{
				pwWhitelist.close();
			}
		}
	}
	
	public static void removeFromWhitelist(String p_strUsername)
	{
		File fWhitelist = new File(LttpTrackerConstants.WHITELIST);
		File fTemp = new File("temp file.txt");
		BufferedReader brWhitelist = null;
		BufferedWriter bwWhitelist = null;
		String strLine;
		boolean bSuccess = false;
		
		try
		{
			brWhitelist = new BufferedReader(new FileReader(fWhitelist));
			bwWhitelist = new BufferedWriter(new FileWriter(fTemp));
			while((strLine = brWhitelist.readLine()) != null)
			{
				if(!strLine.equals(p_strUsername))
				{
					bwWhitelist.write(strLine + "\n");
				}
			}
			bSuccess = true;
		}
		catch(IOException e)
		{
			
		}
		finally
		{
			if(bwWhitelist != null)
			{
				try
				{
					bwWhitelist.close();
				}
				catch(IOException e)
				{
					
				}
			}
			
			if(brWhitelist != null)
			{
				try
				{
					brWhitelist.close();
				}
				catch(IOException e)
				{
					
				}
			}
			
		}
		if(bSuccess)
		{
			try
			{
				if(fWhitelist.delete())
				{
					fTemp.renameTo(fWhitelist);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Set<String> readWhiteListFromFile()
	{
		File fWhitelist = new File(LttpTrackerConstants.WHITELIST);
		BufferedReader brWhitelist = null;
		Set<String> setWhitelist = new HashSet<>();
		String strLine;
		
		try
		{
			brWhitelist = new BufferedReader(new FileReader(fWhitelist));
			while((strLine = brWhitelist.readLine()) != null)
			{
				setWhitelist.add(strLine);
			}
		}
		catch(IOException e)
		{
			
		}
		
		return setWhitelist;
	}
	
	private static BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}
	
}
