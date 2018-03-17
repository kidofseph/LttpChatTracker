package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jibble.pircbot.IrcException;

import backgroundutil.BackgroundUtilities;
import backgroundutil.LttpTrackerConstants;
import bot.LttpTracker;
import exceptions.ApplicationException;
import model.MItem;

public class LttpTrackerGui
{
	
	private static HashMap<String, MItem> m_mapModels;
	private static HashMap<String, JLabel> m_mapLabels;
	private static JFrame m_jFrame = new JFrame("LttP Randomizer Tracker");
	private static Set<String> m_setWhiteList;
	private static int TOP = SwingConstants.TOP;

	public static void main(String[] args)
	{
//		JMenuBar jmbBar = new JMenuBar();
//		JMenu jmConfig = new JMenu("Config");
//		JMenuItem jmiLoad = new JMenuItem("Load Whitelist File...");
		
//		jmiLoad.addActionListener(getLoadWhitelistActionListener());
//		jmConfig.add(jmiLoad);
//		jmbBar.add(jmConfig);
		
		
//		jmConfig.setMnemonic(KeyEvent.VK_F);
		
		m_mapModels = new HashMap<>();
		m_mapLabels = new HashMap<>();
		initializeModels();
		m_jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		m_jFrame.setJMenuBar(jmbBar);
		
		JLabel labelBow = new JLabel();
		labelBow.setIcon(m_mapModels.get(LttpTrackerConstants.BOW).getGrayImage());
		labelBow.setBounds(0, 2, 32, 32);
		labelBow.setVerticalAlignment(SwingConstants.TOP);
//		labelBow.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		m_jFrame.add(labelBow);
		m_mapLabels.put(LttpTrackerConstants.BOW, labelBow);
		
		
		JLabel labelBorder = new JLabel();
		labelBorder.setBounds(0, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		
		m_jFrame.setSize(400, 500);
		m_jFrame.setLayout(null);
		m_jFrame.setVisible(true);
		
		
		JLabel labelHammer = new JLabel();
		labelHammer.setIcon(m_mapModels.get(LttpTrackerConstants.HAMMER).getGrayImage());
		labelHammer.setBounds(32, 0, 33, 32);
		labelHammer.setVerticalAlignment(SwingConstants.TOP);
		m_jFrame.add(labelHammer);
		m_mapLabels.put(LttpTrackerConstants.HAMMER, labelHammer);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(31, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelHookshot = new JLabel();
		labelHookshot.setIcon(m_mapModels.get(LttpTrackerConstants.HOOKSHOT).getGrayImage());
		labelHookshot.setBounds(64, 0, 32, 32);
//		labelHookshot.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelHookshot.setVerticalAlignment(TOP);
		m_jFrame.add(labelHookshot);
		m_mapLabels.put(LttpTrackerConstants.HOOKSHOT, labelHookshot);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(63, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelFireRod = new JLabel();
		labelFireRod.setIcon(m_mapModels.get(LttpTrackerConstants.FIRE_ROD).getGrayImage());
		labelFireRod.setBounds(96, 0, 32, 32);
//		labelFireRod.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelFireRod.setVerticalAlignment(TOP);
		m_jFrame.add(labelFireRod);
		m_mapLabels.put(LttpTrackerConstants.FIRE_ROD, labelFireRod);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(95, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelLantern = new JLabel();
		labelLantern.setIcon(m_mapModels.get(LttpTrackerConstants.LANTERN).getGrayImage());
		labelLantern.setBounds(128, 0, 32, 32);
//		labelLantern.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelLantern.setVerticalAlignment(TOP);
		m_jFrame.add(labelLantern);
		m_mapLabels.put(LttpTrackerConstants.LANTERN, labelLantern);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(127, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelSomaria = new JLabel();
		labelSomaria.setIcon(m_mapModels.get(LttpTrackerConstants.SOMARIA).getGrayImage());
		labelSomaria.setBounds(160, 0, 32, 32);
//		labelSomaria.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelSomaria.setVerticalAlignment(TOP);
		m_jFrame.add(labelSomaria);
		m_mapLabels.put(LttpTrackerConstants.SOMARIA, labelSomaria);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(159, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelSword = new JLabel();
		labelSword.setIcon(m_mapModels.get(LttpTrackerConstants.SWORD).getGrayImage());
		labelSword.setBounds(192, 0, 32, 32);
//		labelSword.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelSword.setVerticalAlignment(TOP);
		m_jFrame.add(labelSword);
		m_mapLabels.put(LttpTrackerConstants.SWORD, labelSword);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(191, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelShield = new JLabel();
		labelShield.setIcon(m_mapModels.get(LttpTrackerConstants.SHIELD).getGrayImage());
		labelShield.setBounds(224, 0, 32, 32);
//		labelShield.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelShield.setVerticalAlignment(TOP);
		m_jFrame.add(labelShield);
		m_mapLabels.put(LttpTrackerConstants.SHIELD, labelShield);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(223, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelTunic = new JLabel();
		labelTunic.setIcon(m_mapModels.get(LttpTrackerConstants.TUNIC).getGrayImage());
		labelTunic.setBounds(256, 0, 32, 32);
//		labelTunic.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelTunic.setVerticalAlignment(TOP);
		m_jFrame.add(labelTunic);
		m_mapLabels.put(LttpTrackerConstants.TUNIC, labelTunic);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(255, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelBottle = new JLabel();
		labelBottle.setIcon(m_mapModels.get(LttpTrackerConstants.BOTTLE).getGrayImage());
		labelBottle.setBounds(288, 0, 32, 32);
//		labelBottle.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBottle.setVerticalAlignment(TOP);
		m_jFrame.add(labelBottle);
		m_mapLabels.put(LttpTrackerConstants.BOTTLE, labelBottle);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(287, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelNet = new JLabel();
		labelNet.setIcon(m_mapModels.get(LttpTrackerConstants.NET).getGrayImage());
		labelNet.setBounds(320, 0, 32, 32);
//		labelNet.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelNet.setVerticalAlignment(TOP);
		m_jFrame.add(labelNet);
		m_mapLabels.put(LttpTrackerConstants.NET, labelNet);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(319, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelByrna = new JLabel();
		labelByrna.setIcon(m_mapModels.get(LttpTrackerConstants.BYRNA).getGrayImage());
		labelByrna.setBounds(352, 0, 32, 32);
//		labelByrna.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelByrna.setVerticalAlignment(TOP);
		m_jFrame.add(labelByrna);
		m_mapLabels.put(LttpTrackerConstants.BYRNA, labelByrna);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(351, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelBoomerang = new JLabel();
		labelBoomerang.setIcon(m_mapModels.get(LttpTrackerConstants.BOOMERANG).getGrayImage());
		labelBoomerang.setBounds(384, 0, 32, 32);
//		labelBoomerang.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBoomerang.setVerticalAlignment(TOP);
		m_jFrame.add(labelBoomerang);
		m_mapLabels.put(LttpTrackerConstants.BOOMERANG, labelBoomerang);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(383, 0, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
//		
//		//ROW 2
		JLabel labelBook = new JLabel();
		labelBook.setIcon(m_mapModels.get(LttpTrackerConstants.BOOK).getGrayImage());
		labelBook.setBounds(0, 34, 32, 32);
//		labelBook.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBook.setVerticalAlignment(TOP);
		m_jFrame.add(labelBook);
		m_mapLabels.put(LttpTrackerConstants.BOOK, labelBook);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(0, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelShovel = new JLabel();
		labelShovel.setIcon(m_mapModels.get(LttpTrackerConstants.SHOVEL).getGrayImage());
		labelShovel.setBounds(32, 34, 32, 32);
//		labelShovel.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelShovel.setVerticalAlignment(TOP);
		m_jFrame.add(labelShovel);
		m_mapLabels.put(LttpTrackerConstants.SHOVEL, labelShovel);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(31, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelFlute = new JLabel();
		labelFlute.setIcon(m_mapModels.get(LttpTrackerConstants.FLUTE).getGrayImage());
		labelFlute.setBounds(64, 33, 32, 32);
//		labelFlute.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelFlute.setVerticalAlignment(TOP);
		m_jFrame.add(labelFlute);
		m_mapLabels.put(LttpTrackerConstants.FLUTE, labelFlute);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(63, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelIceRod = new JLabel();
		labelIceRod.setIcon(m_mapModels.get(LttpTrackerConstants.ICE_ROD).getGrayImage());
		labelIceRod.setBounds(96, 33, 32, 32);
//		labelIceRod.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelIceRod.setVerticalAlignment(TOP);
		m_jFrame.add(labelIceRod);
		m_mapLabels.put(LttpTrackerConstants.ICE_ROD, labelIceRod);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(95, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelMushroom = new JLabel();
		labelMushroom.setIcon(m_mapModels.get(LttpTrackerConstants.MUSHROOM).getGrayImage());
		labelMushroom.setBounds(128, 33, 32, 32);
//		labelMushroom.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelMushroom.setVerticalAlignment(TOP);
		m_jFrame.add(labelMushroom);
		m_mapLabels.put(LttpTrackerConstants.MUSHROOM, labelMushroom);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(127, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelPowder = new JLabel();
		labelPowder.setIcon(m_mapModels.get(LttpTrackerConstants.POWDER).getGrayImage());
		labelPowder.setBounds(160, 33, 32, 32);
//		labelPowder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		m_jFrame.add(labelPowder);
		m_mapLabels.put(LttpTrackerConstants.POWDER, labelPowder);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(159, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelCape = new JLabel();
		labelCape.setIcon(m_mapModels.get(LttpTrackerConstants.CAPE).getGrayImage());
		labelCape.setBounds(192, 33, 32, 32);
//		labelCape.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelCape.setVerticalAlignment(TOP);
		m_jFrame.add(labelCape);
		m_mapLabels.put(LttpTrackerConstants.CAPE, labelCape);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(191, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelFlippers = new JLabel();
		labelFlippers.setIcon(m_mapModels.get(LttpTrackerConstants.FLIPPERS).getGrayImage());
		labelFlippers.setBounds(224, 33, 32, 32);
//		labelFlippers.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelFlippers.setVerticalAlignment(TOP);
		m_jFrame.add(labelFlippers);
		m_mapLabels.put(LttpTrackerConstants.FLIPPERS, labelFlippers);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(223, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelBoots = new JLabel();
		labelBoots.setIcon(m_mapModels.get(LttpTrackerConstants.BOOTS).getGrayImage());
		labelBoots.setBounds(256, 33, 32, 32);
//		labelBoots.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBoots.setVerticalAlignment(TOP);
		m_jFrame.add(labelBoots);
		m_mapLabels.put(LttpTrackerConstants.BOOTS, labelBoots);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(255, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelGlove = new JLabel();
		labelGlove.setIcon(m_mapModels.get(LttpTrackerConstants.GLOVE).getGrayImage());
		labelGlove.setBounds(288, 33, 32, 32);
//		labelGlove.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelGlove.setVerticalAlignment(TOP);
		m_jFrame.add(labelGlove);
		m_mapLabels.put(LttpTrackerConstants.GLOVE, labelGlove);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(287, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelBombos = new JLabel();
		labelBombos.setIcon(m_mapModels.get(LttpTrackerConstants.BOMBOS).getGrayImage());
		labelBombos.setBounds(320, 33, 32, 32);
//		labelBombos.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBombos.setVerticalAlignment(TOP);
		m_jFrame.add(labelBombos);
		m_mapLabels.put(LttpTrackerConstants.BOMBOS, labelBombos);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(319, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelEther = new JLabel();
		labelEther.setIcon(m_mapModels.get(LttpTrackerConstants.ETHER).getGrayImage());
		labelEther.setBounds(352, 33, 32, 32);
//		labelEther.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelEther.setVerticalAlignment(TOP);
		m_jFrame.add(labelEther);
		m_mapLabels.put(LttpTrackerConstants.ETHER, labelEther);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(351, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
		JLabel labelQuake = new JLabel();
		labelQuake.setIcon(m_mapModels.get(LttpTrackerConstants.QUAKE).getGrayImage());
		labelQuake.setBounds(384, 32, 32, 32);
//		labelQuake.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		m_jFrame.add(labelQuake);
		m_mapLabels.put(LttpTrackerConstants.QUAKE, labelQuake);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(383, 33, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
//		
//		
//		
//		//ROW 3
//		JLabel labelCourage = new JLabel();
//		labelCourage.setIcon(m_mapModels.get(LttpTrackerConstants.PENDANT_COURAGE).getGrayImage());
//		labelCourage.setBounds(0, 64, 32, 32);
//		labelCourage.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCourage);
//		m_mapLabels.put(LttpTrackerConstants.PENDANT_COURAGE, labelCourage);
//		
//		JLabel labelPower = new JLabel();
//		labelPower.setIcon(m_mapModels.get(LttpTrackerConstants.PENDANT_POWER).getGrayImage());
//		labelPower.setBounds(32, 64, 32, 32);
//		labelPower.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelPower);
//		m_mapLabels.put(LttpTrackerConstants.PENDANT_POWER, labelPower);
//		
//		JLabel labelWisdom = new JLabel();
//		labelWisdom.setIcon(m_mapModels.get(LttpTrackerConstants.PENDANT_WISDOM).getGrayImage());
//		labelWisdom.setBounds(64, 64, 32, 32);
//		labelWisdom.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelWisdom);
//		m_mapLabels.put(LttpTrackerConstants.PENDANT_WISDOM, labelWisdom);
		
		JLabel labelEasternPalace = new JLabel();
		labelEasternPalace.setIcon(m_mapModels.get(LttpTrackerConstants.EASTERN_PALACE).getGrayImage());
		labelEasternPalace.setBounds(0, 66, 32, 32);
//		labelEasternPalace.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelEasternPalace.setVerticalAlignment(TOP);
		m_jFrame.add(labelEasternPalace);
		m_mapLabels.put(LttpTrackerConstants.EASTERN_PALACE, labelEasternPalace);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(0, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelDesertPalace = new JLabel();
		labelDesertPalace.setIcon(m_mapModels.get(LttpTrackerConstants.DESERT_PALACE).getGrayImage());
		labelDesertPalace.setBounds(32, 66, 32, 32);
//		labelDesertPalace.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelDesertPalace.setVerticalAlignment(TOP);
		m_jFrame.add(labelDesertPalace);
		m_mapLabels.put(LttpTrackerConstants.DESERT_PALACE, labelDesertPalace);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(31, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelTowerOfHera = new JLabel();
		labelTowerOfHera.setIcon(m_mapModels.get(LttpTrackerConstants.TOWER_OF_HERA).getGrayImage());
		labelTowerOfHera.setBounds(64, 66, 32, 32);
//		labelTowerOfHera.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelTowerOfHera.setVerticalAlignment(TOP);
		m_jFrame.add(labelTowerOfHera);
		m_mapLabels.put(LttpTrackerConstants.TOWER_OF_HERA, labelTowerOfHera);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(63, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelMoonPearl = new JLabel();
		labelMoonPearl.setIcon(m_mapModels.get(LttpTrackerConstants.MOON_PEARL).getGrayImage());
		labelMoonPearl.setBounds(96, 66, 32, 32);
//		labelMoonPearl.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelMoonPearl.setVerticalAlignment(TOP);
		m_jFrame.add(labelMoonPearl);
		m_mapLabels.put(LttpTrackerConstants.MOON_PEARL, labelMoonPearl);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(95, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelMirror = new JLabel();
		labelMirror.setIcon(m_mapModels.get(LttpTrackerConstants.MIRROR).getGrayImage());
		labelMirror.setBounds(128, 66, 32, 32);
//		labelMirror.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelMirror.setVerticalAlignment(TOP);
		m_jFrame.add(labelMirror);
		m_mapLabels.put(LttpTrackerConstants.MIRROR, labelMirror);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(127, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelAgahnim = new JLabel();
		labelAgahnim.setIcon(m_mapModels.get(LttpTrackerConstants.AGAHNIM).getGrayImage());
		labelAgahnim.setBounds(160, 66, 32, 32);
//		labelAgahnim.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelAgahnim.setVerticalAlignment(TOP);
		m_jFrame.add(labelAgahnim);
		m_mapLabels.put(LttpTrackerConstants.AGAHNIM, labelAgahnim);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(0, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
//		JLabel labelCrystal1 = new JLabel();
//		labelCrystal1.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL1).getGrayImage());
//		labelCrystal1.setBounds(192, 64, 32, 32);
//		labelCrystal1.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal1);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL1, labelCrystal1);
//		
//		JLabel labelCrystal2 = new JLabel();
//		labelCrystal2.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL2).getGrayImage());
//		labelCrystal2.setBounds(224, 64, 32, 32);
//		labelCrystal2.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal2);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL2, labelCrystal2);
//		
//		JLabel labelCrystal3 = new JLabel();
//		labelCrystal3.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL3).getGrayImage());
//		labelCrystal3.setBounds(256, 64, 32, 32);
//		labelCrystal3.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal3);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL3, labelCrystal3);
//		
//		JLabel labelCrystal4 = new JLabel();
//		labelCrystal4.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL4).getGrayImage());
//		labelCrystal4.setBounds(288, 64, 32, 32);
//		labelCrystal4.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal4);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL4, labelCrystal4);
//		
//		JLabel labelCrystal5 = new JLabel();
//		labelCrystal5.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL5).getGrayImage());
//		labelCrystal5.setBounds(320, 64, 32, 32);
//		labelCrystal5.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal5);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL5, labelCrystal5);
//		
//		JLabel labelCrystal6 = new JLabel();
//		labelCrystal6.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL6).getGrayImage());
//		labelCrystal6.setBounds(352, 64, 32, 32);
//		labelCrystal6.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal6);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL6, labelCrystal6);
//		
//		JLabel labelCrystal7 = new JLabel();
//		labelCrystal7.setIcon(m_mapModels.get(LttpTrackerConstants.CRYSTAL7).getGrayImage());
//		labelCrystal7.setBounds(384, 64, 32, 32);
//		labelCrystal7.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
//		m_jFrame.add(labelCrystal7);
//		m_mapLabels.put(LttpTrackerConstants.CRYSTAL7, labelCrystal7);
		
		JLabel labelPalaceOfDarkness = new JLabel();
		labelPalaceOfDarkness.setIcon(m_mapModels.get(LttpTrackerConstants.PALACE_OF_DARKNESS).getGrayImage());
		labelPalaceOfDarkness.setBounds(192, 66, 32, 32);
//		labelPalaceOfDarkness.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelPalaceOfDarkness.setVerticalAlignment(TOP);
		m_jFrame.add(labelPalaceOfDarkness);
		m_mapLabels.put(LttpTrackerConstants.PALACE_OF_DARKNESS, labelPalaceOfDarkness);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(191, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelSwampPalace = new JLabel();
		labelSwampPalace.setIcon(m_mapModels.get(LttpTrackerConstants.SWAMP_PALACE).getGrayImage());
		labelSwampPalace.setBounds(224, 66, 32, 32);
//		labelSwampPalace.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelSwampPalace.setVerticalAlignment(TOP);
		m_jFrame.add(labelSwampPalace);
		m_mapLabels.put(LttpTrackerConstants.SWAMP_PALACE, labelSwampPalace);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(223, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelSkullWoods = new JLabel();
		labelSkullWoods.setIcon(m_mapModels.get(LttpTrackerConstants.SKULL_WOODS).getGrayImage());
		labelSkullWoods.setBounds(256, 66, 32, 32);
//		labelSkullWoods.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelSkullWoods.setVerticalAlignment(TOP);
		m_jFrame.add(labelSkullWoods);
		m_mapLabels.put(LttpTrackerConstants.SKULL_WOODS, labelSkullWoods);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(255, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelThievesTown = new JLabel();
		labelThievesTown.setIcon(m_mapModels.get(LttpTrackerConstants.THIEVES_TOWN).getGrayImage());
		labelThievesTown.setBounds(288, 66, 32, 32);
//		labelThievesTown.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelThievesTown.setVerticalAlignment(TOP);
		m_jFrame.add(labelThievesTown);
		m_mapLabels.put(LttpTrackerConstants.THIEVES_TOWN, labelThievesTown);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(287, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelIcePalace = new JLabel();
		labelIcePalace.setIcon(m_mapModels.get(LttpTrackerConstants.ICE_PALACE).getGrayImage());
		labelIcePalace.setBounds(320, 66, 32, 32);
//		labelIcePalace.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelIcePalace.setVerticalAlignment(TOP);
		m_jFrame.add(labelIcePalace);
		m_mapLabels.put(LttpTrackerConstants.ICE_PALACE, labelIcePalace);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(319, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelMiseryMire = new JLabel();
		labelMiseryMire.setIcon(m_mapModels.get(LttpTrackerConstants.MISERY_MIRE).getGrayImage());
		labelMiseryMire.setBounds(352, 66, 32, 32);
//		labelMiseryMire.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelMiseryMire.setVerticalAlignment(TOP);
		m_jFrame.add(labelMiseryMire);
		m_mapLabels.put(LttpTrackerConstants.MISERY_MIRE, labelMiseryMire);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(351, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		JLabel labelTurtleRock = new JLabel();
		labelTurtleRock.setIcon(m_mapModels.get(LttpTrackerConstants.TURTLE_ROCK).getGrayImage());
		labelTurtleRock.setBounds(384, 66, 32, 32);
//		labelTurtleRock.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelTurtleRock.setVerticalAlignment(TOP);
		m_jFrame.add(labelTurtleRock);
		m_mapLabels.put(LttpTrackerConstants.TURTLE_ROCK, labelTurtleRock);
		
		labelBorder = new JLabel();
		labelBorder.setBounds(383, 66, 33, 33);
		labelBorder.setBorder(new MatteBorder(2, 2, 2, 2, new Color(240, 230, 140)));
		labelBorder.setVerticalAlignment(SwingConstants.BOTTOM);
		m_jFrame.add(labelBorder);
		
		
		m_jFrame.getContentPane().setBackground(new Color(148, 192, 151));
		m_jFrame.repaint();
		m_jFrame.setSize(435, 140);
		m_jFrame.setLayout(null);
		m_jFrame.setVisible(true);
		
		try
		{
			LttpTracker bot = new LttpTracker();
			bot.setVerbose(true);
			bot.connect("irc.chat.twitch.tv", 6667, "");
			bot.joinChannel("#" + LttpTrackerConstants.USER);
		}
		catch(IrcException | IOException e)
		{
			e.printStackTrace();
		}

	}
	
	public static void resetModels()
	{
		for(String strKey : m_mapModels.keySet())
		{
			m_mapModels.get(strKey).resetIcon();
			redrawIcon(m_mapLabels.get(strKey), m_mapModels.get(strKey).getCurrentIcon());
		}
		m_jFrame.repaint();
	}
	
	private static void initializeModels()
	{
		MItem itemBow = new MItem();
		itemBow.setName(LttpTrackerConstants.BOW);
		itemBow.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOW2, true), 0);
		itemBow.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SILVER_ARROW, false), 1);
		itemBow.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOW2, false), 2);
		itemBow.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOW3, false), 3);
		m_mapModels.put(LttpTrackerConstants.BOW, itemBow);
		
		MItem itemHammer = new MItem();
		itemHammer.setName(LttpTrackerConstants.HAMMER);
		itemHammer.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.HAMMER, true), 0);
		itemHammer.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.HAMMER, false), 1);
		m_mapModels.put(LttpTrackerConstants.HAMMER, itemHammer);
		
		MItem itemHookshot = new MItem();
		itemHookshot.setName(LttpTrackerConstants.HOOKSHOT);
		itemHookshot.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.HOOKSHOT, true), 0);
		itemHookshot.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.HOOKSHOT, false), 1);
		m_mapModels.put(LttpTrackerConstants.HOOKSHOT, itemHookshot);
		
		MItem itemFireRod = new MItem();
		itemFireRod.setName(LttpTrackerConstants.FIRE_ROD);
		itemFireRod.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FIRE_ROD, true), 0);
		itemFireRod.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FIRE_ROD, false), 1);
		m_mapModels.put(LttpTrackerConstants.FIRE_ROD, itemFireRod);
		
		MItem itemLantern = new MItem();
		itemLantern.setName(LttpTrackerConstants.LANTERN);
		itemLantern.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.LANTERN, true), 0);
		itemLantern.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.LANTERN, false), 1);
		m_mapModels.put(LttpTrackerConstants.LANTERN, itemLantern);
		
		MItem itemSomaria = new MItem();
		itemSomaria.setName(LttpTrackerConstants.SOMARIA);
		itemSomaria.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SOMARIA, true), 0);
		itemSomaria.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SOMARIA, false), 1);
		m_mapModels.put(LttpTrackerConstants.SOMARIA, itemSomaria);
		
		MItem itemSword = new MItem();
		itemSword.setName(LttpTrackerConstants.SWORD);
		itemSword.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWORD, true), 0);
		itemSword.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWORD1, false), 1);
		itemSword.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWORD2, false), 2);
		itemSword.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWORD3, false), 3);
		itemSword.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWORD4, false), 4);
		m_mapModels.put(LttpTrackerConstants.SWORD, itemSword);
		
		MItem itemShield = new MItem();
		itemShield.setName(LttpTrackerConstants.SHIELD);
		itemShield.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHIELD1, true), 0);
		itemShield.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHIELD1, false), 1);
		itemShield.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHIELD2, false), 2);
		itemShield.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHIELD3, false), 3);
		m_mapModels.put(LttpTrackerConstants.SHIELD, itemShield);
		
		MItem itemTunic= new MItem();
		itemTunic.setName(LttpTrackerConstants.TUNIC);
		itemTunic.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TUNIC1, true), 0);
		itemTunic.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TUNIC1, false), 1);
		itemTunic.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TUNIC2, false), 2);
		itemTunic.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TUNIC3, false), 3);
		
		m_mapModels.put(LttpTrackerConstants.TUNIC, itemTunic);
		
		MItem itemBottle = new MItem();
		itemBottle.setName(LttpTrackerConstants.BOTTLE);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE, true), 0);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE1, false), 1);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE2, false), 2);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE3, false), 3);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE4, false), 4);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE_RED, false), 5);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE_GREEN, false), 6);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE_BLUE, false), 7);
		itemBottle.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOTTLE_FAIRY, false), 8);
		m_mapModels.put(LttpTrackerConstants.BOTTLE, itemBottle);
		
		MItem itemNet = new MItem();
		itemNet.setName(LttpTrackerConstants.NET);
		itemNet.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.NET, true), 0);
		itemNet.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.NET, false), 1);
		m_mapModels.put(LttpTrackerConstants.NET, itemNet);
		
		MItem itemByrna = new MItem();
		itemByrna.setName(LttpTrackerConstants.NET);
		itemByrna.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BYRNA, true), 0);
		itemByrna.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BYRNA, false), 1);
		m_mapModels.put(LttpTrackerConstants.BYRNA, itemByrna);
		
		MItem itemBoomerang = new MItem();
		itemBoomerang.setName(LttpTrackerConstants.BOOMERANG);
		itemBoomerang.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOMERANG1, true), 0);
		itemBoomerang.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOMERANG1, false), 1);
		itemBoomerang.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOMERANG2, false), 2);
		m_mapModels.put(LttpTrackerConstants.BOOMERANG, itemBoomerang);
		
		MItem itemBook = new MItem();
		itemBook.setName(LttpTrackerConstants.BOOK);
		itemBook.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOK, true), 0);
		itemBook.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOK, false), 1);
		m_mapModels.put(LttpTrackerConstants.BOOK, itemBook);
		
		MItem itemShovel = new MItem();
		itemShovel.setName(LttpTrackerConstants.SHOVEL);
		itemShovel.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHOVEL, true), 0);
		itemShovel.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHOVEL, false), 1);
		itemShovel.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SHOVEL_USED, false), 2);
		m_mapModels.put(LttpTrackerConstants.SHOVEL, itemShovel);
		
		MItem itemFlute = new MItem();
		itemFlute.setName(LttpTrackerConstants.FLUTE);
		itemFlute.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FLUTE, true), 0);
		itemFlute.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FLUTE, false), 1);
		m_mapModels.put(LttpTrackerConstants.FLUTE, itemFlute);
		
		MItem itemIceRod = new MItem();
		itemIceRod.setName(LttpTrackerConstants.ICE_ROD);
		itemIceRod.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_ROD, true), 0);
		itemIceRod.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_ROD, false), 1);
		m_mapModels.put(LttpTrackerConstants.ICE_ROD, itemIceRod);
		
		MItem itemMushroom = new MItem();
		itemMushroom.setName(LttpTrackerConstants.MUSHROOM);
		itemMushroom.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MUSHROOM, true), 0);
		itemMushroom.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MUSHROOM, false), 1);
		itemMushroom.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MUSHROOM_USED, false), 2);
		m_mapModels.put(LttpTrackerConstants.MUSHROOM, itemMushroom);
		
		MItem itemPowder = new MItem();
		itemPowder.setName(LttpTrackerConstants.POWDER);
		itemPowder.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.POWDER, true), 0);
		itemPowder.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.POWDER, false), 1);
		itemPowder.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.POWDER_USED, false), 2);
		m_mapModels.put(LttpTrackerConstants.POWDER, itemPowder);
		
		MItem itemCape = new MItem();
		itemCape.setName(LttpTrackerConstants.CAPE);
		itemCape.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CAPE, true), 0);
		itemCape.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CAPE, false), 1);
		m_mapModels.put(LttpTrackerConstants.CAPE, itemCape);
		
		MItem itemFlippers = new MItem();
		itemFlippers.setName(LttpTrackerConstants.FLIPPERS);
		itemFlippers.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FLIPPERS, true), 0);
		itemFlippers.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.FLIPPERS, false), 1);
		m_mapModels.put(LttpTrackerConstants.FLIPPERS, itemFlippers);
		
		MItem itemBoots = new MItem();
		itemBoots.setName(LttpTrackerConstants.BOOTS);
		itemBoots.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOTS, true), 0);
		itemBoots.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOOTS, false), 1);
		m_mapModels.put(LttpTrackerConstants.BOOTS, itemBoots);
		
		MItem itemGlove = new MItem();
		itemGlove.setName(LttpTrackerConstants.GLOVE);
		itemGlove.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.GLOVE1, true), 0);
		itemGlove.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.GLOVE1, false), 1);
		itemGlove.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.GLOVE2, false), 2);
		m_mapModels.put(LttpTrackerConstants.GLOVE, itemGlove);
		
		MItem itemBombos = new MItem();
		itemBombos.setName(LttpTrackerConstants.BOMBOS);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS, true), 0);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS, false), 1);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_MM, true), 2);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_MM, false), 3);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_TR, true), 4);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_TR, false), 5);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_2, true), 6);
		itemBombos.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.BOMBOS_2, false), 7);
		m_mapModels.put(LttpTrackerConstants.BOMBOS, itemBombos);
		
		MItem itemEther = new MItem();
		itemEther.setName(LttpTrackerConstants.ETHER);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER, true), 0);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER, false), 1);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_MM, true), 2);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_MM, false), 3);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_TR, true), 4);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_TR, false), 5);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_2, true), 6);
		itemEther.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ETHER_2, false), 7);
		m_mapModels.put(LttpTrackerConstants.ETHER, itemEther);
		
		MItem itemQuake = new MItem();
		itemQuake.setName(LttpTrackerConstants.QUAKE);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE, true), 0);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE, false), 1);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_MM, true), 2);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_MM, false), 3);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_TR, true), 4);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_TR, false), 5);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_2, true), 6);
		itemQuake.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.QUAKE_2, false), 7);
		m_mapModels.put(LttpTrackerConstants.QUAKE, itemQuake);
		
		MItem itemEP = new MItem();
		itemEP.setName(LttpTrackerConstants.EASTERN_PALACE);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL, true), 0);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL, false), 1);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_PENDANT, true), 2);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_PENDANT, false), 3);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_PENDANT_PLUS, true), 4);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_PENDANT_PLUS, false), 5);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL_PLUS, true), 6);
		itemEP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.EASTERN_PALACE_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.EASTERN_PALACE, itemEP);
		
		MItem itemDP = new MItem();
		itemDP.setName(LttpTrackerConstants.DESERT_PALACE);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_CRYSTAL, true), 0);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_CRYSTAL, false), 1);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_PENDANT, true), 2);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_PENDANT, false), 3);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_PENDANT_PLUS, true), 4);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_PENDANT_PLUS, false), 5);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_CRYSTAL_PLUS, true), 6);
		itemDP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.DESERT_PALACE_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.DESERT_PALACE, itemDP);
		
		MItem itemTOH = new MItem();
		itemTOH.setName(LttpTrackerConstants.TOWER_OF_HERA);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL, true), 0);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL, false), 1);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_PENDANT, true), 2);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_PENDANT, false), 3);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_PENDANT_PLUS, true), 4);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_PENDANT_PLUS, false), 5);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL_PLUS, true), 6);
		itemTOH.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TOWER_OF_HERA_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.TOWER_OF_HERA, itemTOH);
		
		MItem itemPOD = new MItem();
		itemPOD.setName(LttpTrackerConstants.PALACE_OF_DARKNESS);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL, true), 0);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL, false), 1);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT, true), 2);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT, false), 3);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT_PLUS, true), 4);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_PENDANT_PLUS, false), 5);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL_PLUS, true), 6);
		itemPOD.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PALACE_OF_DARKNESS_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.PALACE_OF_DARKNESS, itemPOD);
		
		MItem itemSP = new MItem();
		itemSP.setName(LttpTrackerConstants.SWAMP_PALACE);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL, true), 0);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL, false), 1);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_PENDANT, true), 2);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_PENDANT, false), 3);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_PENDANT_PLUS, true), 4);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_PENDANT_PLUS, false), 5);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL_PLUS, true), 6);
		itemSP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SWAMP_PALACE_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.SWAMP_PALACE, itemSP);
		
		MItem itemSW = new MItem();
		itemSW.setName(LttpTrackerConstants.SKULL_WOODS);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_CRYSTAL, true), 0);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_CRYSTAL, false), 1);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_PENDANT, true), 2);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_PENDANT, false), 3);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_PENDANT_PLUS, true), 4);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_PENDANT_PLUS, false), 5);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_CRYSTAL_PLUS, true), 6);
		itemSW.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.SKULL_WOODS_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.SKULL_WOODS, itemSW);
		
		MItem itemTT = new MItem();
		itemTT.setName(LttpTrackerConstants.THIEVES_TOWN);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL, true), 0);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL, false), 1);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_PENDANT, true), 2);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_PENDANT, false), 3);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_PENDANT_PLUS, true), 4);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_PENDANT_PLUS, false), 5);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL_PLUS, true), 6);
		itemTT.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.THIEVES_TOWN_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.THIEVES_TOWN, itemTT);
		
		MItem itemIP = new MItem();
		itemIP.setName(LttpTrackerConstants.ICE_PALACE);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_CRYSTAL, true), 0);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_CRYSTAL, false), 1);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_PENDANT, true), 2);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_PENDANT, false), 3);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_PENDANT_PLUS, true), 4);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_PENDANT_PLUS, false), 5);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_CRYSTAL_PLUS, true), 6);
		itemIP.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.ICE_PALACE_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.ICE_PALACE, itemIP);
		
		MItem itemMM = new MItem();
		itemMM.setName(LttpTrackerConstants.MISERY_MIRE);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_CRYSTAL, true), 0);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_CRYSTAL, false), 1);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_PENDANT, true), 2);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_PENDANT, false), 3);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_PENDANT_PLUS, true), 4);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_PENDANT_PLUS, false), 5);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_CRYSTAL_PLUS, true), 6);
		itemMM.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MISERY_MIRE_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.MISERY_MIRE, itemMM);
		
		MItem itemTR = new MItem();
		itemTR.setName(LttpTrackerConstants.TURTLE_ROCK);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL, true), 0);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL, false), 1);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_PENDANT, true), 2);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_PENDANT, false), 3);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_PENDANT_PLUS, true), 4);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_PENDANT_PLUS, false), 5);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL_PLUS, true), 6);
		itemTR.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.TURTLE_ROCK_CRYSTAL_PLUS, false), 7);
		m_mapModels.put(LttpTrackerConstants.TURTLE_ROCK, itemTR);
		
//		MItem itemPower = new MItem();
//		itemPower.setName(LttpTrackerConstants.PENDANT_POWER);
//		itemPower.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_POWER, true), 0);
//		itemPower.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_POWER, false), 1);
//		m_mapModels.put(LttpTrackerConstants.PENDANT_POWER, itemPower);
//		
//		MItem itemCourage = new MItem();
//		itemCourage.setName(LttpTrackerConstants.PENDANT_COURAGE);
//		itemCourage.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_COURAGE, true), 0);
//		itemCourage.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_COURAGE, false), 1);
//		m_mapModels.put(LttpTrackerConstants.PENDANT_COURAGE, itemCourage);
//		
//		MItem itemWisdom = new MItem();
//		itemWisdom.setName(LttpTrackerConstants.PENDANT_WISDOM);
//		itemWisdom.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_WISDOM, true), 0);
//		itemWisdom.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.PENDANT_WISDOM, false), 1);
//		m_mapModels.put(LttpTrackerConstants.PENDANT_WISDOM, itemWisdom);
		
		MItem itemPearl = new MItem();
		itemPearl.setName(LttpTrackerConstants.MOON_PEARL);
		itemPearl.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MOON_PEARL, true), 0);
		itemPearl.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MOON_PEARL, false), 1);
		m_mapModels.put(LttpTrackerConstants.MOON_PEARL, itemPearl);
		
		MItem itemMirror = new MItem();
		itemMirror.setName(LttpTrackerConstants.MIRROR);
		itemMirror.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MIRROR, true), 0);
		itemMirror.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.MIRROR, false), 1);
		m_mapModels.put(LttpTrackerConstants.MIRROR, itemMirror);
		
		MItem itemAgahnim = new MItem();
		itemAgahnim.setName(LttpTrackerConstants.AGAHNIM);
		itemAgahnim.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.AGAHNIM, true), 0);
		itemAgahnim.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.AGAHNIM, false), 1);
		m_mapModels.put(LttpTrackerConstants.AGAHNIM, itemAgahnim);
		
//		MItem itemCrystal1 = new MItem();
//		itemCrystal1.setName(LttpTrackerConstants.CRYSTAL1);
//		itemCrystal1.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL1, true), 0);
//		itemCrystal1.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL1, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL1, itemCrystal1);
//		
//		MItem itemCrystal2 = new MItem();
//		itemCrystal2.setName(LttpTrackerConstants.CRYSTAL2);
//		itemCrystal2.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL2, true), 0);
//		itemCrystal2.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL2, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL2, itemCrystal2);
//		
//		MItem itemCrystal3 = new MItem();
//		itemCrystal3.setName(LttpTrackerConstants.CRYSTAL3);
//		itemCrystal3.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL3, true), 0);
//		itemCrystal3.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL3, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL3, itemCrystal3);
//		
//		MItem itemCrystal4 = new MItem();
//		itemCrystal4.setName(LttpTrackerConstants.CRYSTAL4);
//		itemCrystal4.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL4, true), 0);
//		itemCrystal4.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL4, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL4, itemCrystal4);
//		
//		MItem itemCrystal5 = new MItem();
//		itemCrystal5.setName(LttpTrackerConstants.CRYSTAL5);
//		itemCrystal5.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL5, true), 0);
//		itemCrystal5.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL5, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL5, itemCrystal5);
//		
//		MItem itemCrystal6 = new MItem();
//		itemCrystal6.setName(LttpTrackerConstants.CRYSTAL6);
//		itemCrystal6.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL6, true), 0);
//		itemCrystal6.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL6, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL6, itemCrystal6);
//		
//		MItem itemCrystal7 = new MItem();
//		itemCrystal7.setName(LttpTrackerConstants.CRYSTAL7);
//		itemCrystal7.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL7, true), 0);
//		itemCrystal7.addImage(BackgroundUtilities.getIcon(LttpTrackerConstants.CRYSTAL7, false), 1);
//		m_mapModels.put(LttpTrackerConstants.CRYSTAL7, itemCrystal7);
	}
	
	private static MItem getItem(String p_strItemName)
	{
		if(m_mapModels.containsKey(p_strItemName))
		{
			return m_mapModels.get(p_strItemName);
		}
		else
		{
			return null;
		}
	}
	
	public static void incrementItem(String p_strItem) throws ApplicationException 
	{
		if(getItem(p_strItem) != null)
		{
			boolean bUpdate = true;
			if(getItem(p_strItem).getLastUpdated() != null)
			{
				Date dtLastUpdated = getItem(p_strItem).getLastUpdated();
				Date dtCurrent = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtLastUpdated);
				cal.add(Calendar.SECOND, 5);
				
				if(dtCurrent.before(cal.getTime()))
				{
					bUpdate = false;
				}
			}
			if(bUpdate)
			{
				if(p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE) || p_strItem.equals(LttpTrackerConstants.DESERT_PALACE) || 
						p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA) || p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS) || 
						p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE) || p_strItem.equals(LttpTrackerConstants.SKULL_WOODS) || 
						p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN) || p_strItem.equals(LttpTrackerConstants.ICE_PALACE) || 
						p_strItem.equals(LttpTrackerConstants.MISERY_MIRE) || p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK))
				{

					if(!getItem(p_strItem).isLit())
					{
						getItem(p_strItem).incrementImage();
						getItem(p_strItem).setLastUpdated(new Date());
						redrawIcon(m_mapLabels.get(p_strItem), getItem(p_strItem).getCurrentIcon());
					}
				}
				else
				{
					
					getItem(p_strItem).incrementImage();
					getItem(p_strItem).setLastUpdated(new Date());
					redrawIcon(m_mapLabels.get(p_strItem), getItem(p_strItem).getCurrentIcon());
				}
			}
			
		}
		else
		{
			throw new ApplicationException("Invalid item");
		}
	}
	
	public static void decrementItem(String p_strItem) throws ApplicationException 
	{
		if(getItem(p_strItem) != null)
		{
			boolean bUpdate = true;
			if(getItem(p_strItem).getLastUpdated() != null)
			{
				Date dtLastUpdated = getItem(p_strItem).getLastUpdated();
				Date dtCurrent = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtLastUpdated);
				cal.add(Calendar.SECOND, 5);
				
				if(dtCurrent.before(cal.getTime()))
				{
					bUpdate = false;
				}
			}
			if(bUpdate)
			{
				if(p_strItem.equals(LttpTrackerConstants.EASTERN_PALACE) || p_strItem.equals(LttpTrackerConstants.DESERT_PALACE) || 
						p_strItem.equals(LttpTrackerConstants.TOWER_OF_HERA) || p_strItem.equals(LttpTrackerConstants.PALACE_OF_DARKNESS) || 
						p_strItem.equals(LttpTrackerConstants.SWAMP_PALACE) || p_strItem.equals(LttpTrackerConstants.SKULL_WOODS) || 
						p_strItem.equals(LttpTrackerConstants.THIEVES_TOWN) || p_strItem.equals(LttpTrackerConstants.ICE_PALACE) || 
						p_strItem.equals(LttpTrackerConstants.MISERY_MIRE) || p_strItem.equals(LttpTrackerConstants.TURTLE_ROCK))
				{

					if(getItem(p_strItem).isLit())
					{
						getItem(p_strItem).decrementImage();
						getItem(p_strItem).setLastUpdated(new Date());
						redrawIcon(m_mapLabels.get(p_strItem), getItem(p_strItem).getCurrentIcon());
					}
				}
				else
				{
					
					getItem(p_strItem).decrementImage();
					getItem(p_strItem).setLastUpdated(new Date());
					redrawIcon(m_mapLabels.get(p_strItem), getItem(p_strItem).getCurrentIcon());
				}
			}
			
		}
		else
		{
			throw new ApplicationException("Invalid item");
		}
	}
	
	public static void setDungeon(String p_strDungeon, String p_strReward)
	{
		if(getItem(p_strDungeon) != null)
		{
			boolean bUpdate = true;
			if(getItem(p_strDungeon).getLastUpdated() != null)
			{
				Date dtLastUpdated = getItem(p_strDungeon).getLastUpdated();
				Date dtCurrent = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtLastUpdated);
				cal.add(Calendar.SECOND, 5);
				
				if(cal.getTime().after(dtCurrent))
				{
					bUpdate = false;
				}
			}
			if(bUpdate)
			{
				getItem(p_strDungeon).setDungeonRequirement(p_strReward);
				getItem(p_strDungeon).setLastUpdated(new Date());
				redrawIcon(m_mapLabels.get(p_strDungeon), getItem(p_strDungeon).getCurrentIcon());
			}
		}
	}
	
	public static void setDungeonPrize(String p_strDungeon, String p_strReward)
	{
		if(getItem(p_strDungeon) != null)
		{
			boolean bUpdate = true;
			if(getItem(p_strDungeon).getLastUpdated() != null)
			{
				Date dtLastUpdated = getItem(p_strDungeon).getLastUpdated();
				Date dtCurrent = new Date();
				Calendar cal = Calendar.getInstance();
				cal.setTime(dtLastUpdated);
				cal.add(Calendar.SECOND, 5);
				
				if(cal.getTime().after(dtCurrent))
				{
					bUpdate = false;
				}
			}
			if(bUpdate)
			{
				getItem(p_strDungeon).setDungeonPrize(p_strReward);
				getItem(p_strDungeon).setLastUpdated(new Date());
				redrawIcon(m_mapLabels.get(p_strDungeon), getItem(p_strDungeon).getCurrentIcon());
			}
		}
	}
	
	private static void redrawIcon(JLabel p_label, ImageIcon p_icon)
	{
		p_label.setIcon(p_icon);
	}
	
	public static Set<String> getWhiteList()
	{
		return m_setWhiteList;
	}
	
	private static ActionListener getLoadWhitelistActionListener()
	{
		return new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				m_setWhiteList = new HashSet<String>();
				JFileChooser jfcWhiteList = new JFileChooser();
				jfcWhiteList.setFileFilter(new FileNameExtensionFilter("text files", "txt"));
				int iReturnVal = jfcWhiteList.showOpenDialog(null);
				if(iReturnVal == JFileChooser.APPROVE_OPTION)
				{
					BufferedReader bufferedReader = null;
					FileReader fileReader = null;
					try
					{
						File file = jfcWhiteList.getSelectedFile();
						fileReader = new FileReader(file);
						bufferedReader = new BufferedReader(fileReader);
						String strLine;
						while((strLine = bufferedReader.readLine()) != null)
						{
							m_setWhiteList.add(strLine.toUpperCase());
						}
					}
					catch(IOException ex)
					{
						ex.printStackTrace();
					}
					finally
					{
						if(bufferedReader != null)
						{
							try
							{
								bufferedReader.close();
								fileReader.close();
								
							}
							catch(IOException ioex)
							{
								ioex.printStackTrace();
							}
						}
					}
				}
			}
		};
	}

}
