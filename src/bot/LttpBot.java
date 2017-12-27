package bot;

import backgroundutil.LttpTrackerConstants;

public class LttpBot
{

	public static void main(String[] args) throws Exception
	{
		LttpTracker bot = new LttpTracker();
		bot.setVerbose(true);
		bot.connect("irc.chat.twitch.tv", 6667, "oauth:ca3ww72dfyhq39yea6pfn6oktaee0o");
		bot.joinChannel("#" + LttpTrackerConstants.USER);
	}

}
