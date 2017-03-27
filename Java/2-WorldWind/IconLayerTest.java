package com.ouc.wind;

import gov.nasa.worldwind.WorldWindow;
import gov.nasa.worldwind.avlist.AVKey;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.geom.Angle;
import gov.nasa.worldwind.geom.Position;
import gov.nasa.worldwind.layers.CompassLayer;
import gov.nasa.worldwind.layers.IconLayer;
import gov.nasa.worldwind.layers.Layer;
import gov.nasa.worldwind.layers.LayerList;
import gov.nasa.worldwind.layers.RenderableLayer;
import gov.nasa.worldwind.layers.ViewControlsLayer;
import gov.nasa.worldwind.layers.WorldMapLayer;
import gov.nasa.worldwind.layers.placename.PlaceNameLayer;
import gov.nasa.worldwind.render.UserFacingIcon;
import gov.nasa.worldwindx.examples.ApplicationTemplate;
import java.awt.event.MouseAdapter;

public class IconLayerTest extends ApplicationTemplate {
    public static Boolean boolean1 = true;

    public static class AppFrame extends ApplicationTemplate.AppFrame {
	private static final long serialVersionUID = -7803809256265054209L;
	
	MouseClickTest test = null;

	public AppFrame() {
	    super(true, false, false);
	    WorldWindow ww = getWwd();
	    test = new MouseClickTest(ww, this);
	    ww.addSelectListener(new WWIconSelectListener(
		    (WorldWindowGLCanvas) ww));
	}
    }

    public static class MouseClickTest extends MouseAdapter {
	WorldWindow ww = null;
	RenderableLayer layer = null;
	AppFrame appFrame = null;

	public MouseClickTest(WorldWindow ww, AppFrame appFrame) {
	    this.ww = ww;
	    this.appFrame = appFrame;
	    int compassPosition1 = 0;
	    int PlaceNameLayer1 = 0;
	    int WorldMapLayer1 = 0;
	    int ViewControlsLayer1 = 0;
	    LayerList layers = ww.getModel().getLayers();
	    for (Layer l : layers) {
		if (l instanceof CompassLayer) {
		    compassPosition1 = layers.indexOf(l);
		} else if (l instanceof PlaceNameLayer) {
		    PlaceNameLayer1 = layers.indexOf(l);
		} else if (l instanceof WorldMapLayer) {
		    WorldMapLayer1 = layers.indexOf(l);
		} else if (l instanceof ViewControlsLayer) {
		    ViewControlsLayer1 = layers.indexOf(l);
		}
	    }
	    if (compassPosition1 > 0)
		layers.remove(compassPosition1);
	    if (ViewControlsLayer1 > 0)
		layers.remove(ViewControlsLayer1);
	    if (WorldMapLayer1 > 0)
		layers.remove(WorldMapLayer1);
	    if (PlaceNameLayer1 > 0)
		layers.remove(PlaceNameLayer1);
	    Redraw();
	    ww.getInputHandler().addMouseListener(this);
	}

	public void Redraw() {
	    if (boolean1) {
		boolean1 = false;

		IconLayer iconLayer1 = new IconLayer();
		iconLayer1.setName("武汉");
		iconLayer1.setPickEnabled(false);
		UserFacingIcon ufi1 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(30.490702),
				Angle.fromDegrees(114.191845),
				18.389055141638202));
		ufi1.setShowToolTip(true);
		ufi1.setValue(AVKey.DISPLAY_NAME, "点a");
		iconLayer1.addIcon(ufi1);

		IconLayer iconLayer2 = new IconLayer();
		iconLayer2.setName("黄岛");
		iconLayer2.setPickEnabled(false);
		UserFacingIcon ufi2 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(36.009025),
				Angle.fromDegrees(120.154966),
				18.389055141638202));
		ufi2.setShowToolTip(true);
		ufi2.setValue(AVKey.DISPLAY_NAME, "点b");
		iconLayer1.addIcon(ufi2);

		IconLayer iconLayer3 = new IconLayer();
		iconLayer3.setName("胶南");
		iconLayer3.setPickEnabled(false);
		UserFacingIcon ufi3 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(36.002182),
				Angle.fromDegrees(119.903767),
				18.389055141638202));
		ufi3.setShowToolTip(true);
		ufi3.setValue(AVKey.DISPLAY_NAME, "点c");
		iconLayer3.addIcon(ufi3);

		IconLayer iconLayer = new IconLayer();

		iconLayer.setName("青岛");
		iconLayer.setPickEnabled(false);
		UserFacingIcon ufi = new UserFacingIcon("images/pic_green.gif",
			new Position(Angle.fromDegrees(36.142953),
				Angle.fromDegrees(120.432757),
				18.389055141638202));
		ufi.setShowToolTip(true);
		ufi.setValue(AVKey.DISPLAY_NAME, "点d");
		iconLayer.addIcon(ufi);

		IconLayer iconLayer4 = new IconLayer();
		iconLayer4.setName("重庆");
		iconLayer4.setPickEnabled(false);
		UserFacingIcon ufi4 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(29.626859),
				Angle.fromDegrees(106.637337),
				18.389055141638202));
		ufi4.setShowToolTip(true);
		ufi4.setValue(AVKey.DISPLAY_NAME, "点e");
		iconLayer4.addIcon(ufi4);

		IconLayer iconLayer5 = new IconLayer();
		iconLayer5.setName("大连");
		iconLayer5.setPickEnabled(false);
		UserFacingIcon ufi5 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(39.055373),
				Angle.fromDegrees(121.829469),
				18.389055141638202));
		ufi5.setShowToolTip(true);
		ufi5.setValue(AVKey.DISPLAY_NAME, "点f");
		iconLayer5.addIcon(ufi5);

		IconLayer iconLayer6 = new IconLayer();
		iconLayer6.setName("合肥");
		iconLayer6.setPickEnabled(false);
		UserFacingIcon ufi6 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(31.787871),
				Angle.fromDegrees(117.256632),
				18.389055141638202));
		ufi6.setShowToolTip(true);
		ufi6.setValue(AVKey.DISPLAY_NAME, "点g");
		iconLayer6.addIcon(ufi6);

		IconLayer iconLayer7 = new IconLayer();
		iconLayer7.setName("郑州");
		iconLayer7.setPickEnabled(false);
		UserFacingIcon ufi7 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(34.695669),
				Angle.fromDegrees(113.838317),
				18.389055141638202));
		ufi7.setShowToolTip(true);
		ufi7.setValue(AVKey.DISPLAY_NAME, "点h");
		iconLayer7.addIcon(ufi7);

		IconLayer iconLayer8 = new IconLayer();
		iconLayer8.setName("佛山");
		iconLayer8.setPickEnabled(false);
		UserFacingIcon ufi8 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(23.261844),
				Angle.fromDegrees(112.991628),
				18.389055141638202));
		ufi8.setShowToolTip(true);
		ufi8.setValue(AVKey.DISPLAY_NAME, "点i");
		iconLayer8.addIcon(ufi8);

		IconLayer iconLayer9 = new IconLayer();
		iconLayer9.setName("巴基斯坦");
		iconLayer9.setPickEnabled(false);
		UserFacingIcon ufi9 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(34.6240),
				Angle.fromDegrees(68.8447), 18.389055141638202));
		ufi9.setShowToolTip(true);
		ufi9.setValue(AVKey.DISPLAY_NAME, "点j");
		iconLayer9.addIcon(ufi9);

		IconLayer iconLayer10 = new IconLayer();
		iconLayer10.setName("美国");
		iconLayer10.setPickEnabled(false);
		UserFacingIcon ufi10 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(42.1837), Angle
				.fromDegrees(-99.5524), 18.389055141638202));
		ufi10.setShowToolTip(true);
		ufi10.setValue(AVKey.DISPLAY_NAME, "点k");
		iconLayer10.addIcon(ufi10);

		IconLayer iconLayer11 = new IconLayer();
		iconLayer11.setName("印度");
		iconLayer11.setPickEnabled(false);
		UserFacingIcon ufi11 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(22.5300),
				Angle.fromDegrees(77.1508), 18.389055141638202));
		ufi11.setShowToolTip(true);
		ufi11.setValue(AVKey.DISPLAY_NAME, "点l");
		iconLayer11.addIcon(ufi11);

		IconLayer iconLayer12 = new IconLayer();
		iconLayer12.setName("越南");
		iconLayer12.setPickEnabled(false);
		UserFacingIcon ufi12 = new UserFacingIcon("images/pic_red.gif",
			new Position(Angle.fromDegrees(16.0510), Angle
				.fromDegrees(105.7597), 18.389055141638202));
		ufi12.setShowToolTip(true);
		ufi12.setValue(AVKey.DISPLAY_NAME, "点m");
		iconLayer12.addIcon(ufi12);

		ww.getModel().getLayers().add(iconLayer2);
		ww.getModel().getLayers().add(iconLayer1);
		ww.getModel().getLayers().add(iconLayer3);
		ww.getModel().getLayers().add(iconLayer4);
		ww.getModel().getLayers().add(iconLayer5);
		ww.getModel().getLayers().add(iconLayer6);
		ww.getModel().getLayers().add(iconLayer7);
		ww.getModel().getLayers().add(iconLayer8);
		ww.getModel().getLayers().add(iconLayer9);
		ww.getModel().getLayers().add(iconLayer10);
		ww.getModel().getLayers().add(iconLayer11);
		ww.getModel().getLayers().add(iconLayer12);
		ww.getModel().getLayers().add(iconLayer);
	    }
	}
    }

    public static void main(String[] args) {
	ApplicationTemplate.start("海尔集团全球分布", IconLayerTest.AppFrame.class);
    }
}
