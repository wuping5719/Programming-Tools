package com.ouc.wind;

import gov.nasa.worldwind.awt.WorldWindowGLCanvas;
import gov.nasa.worldwind.event.SelectEvent;
import gov.nasa.worldwind.event.SelectListener;
import gov.nasa.worldwind.render.WWIcon;

public class WWIconSelectListener implements SelectListener {
    WWIcon icon = null;
    WorldWindowGLCanvas wwg = null;

    public WWIconSelectListener(WorldWindowGLCanvas wwg) {
	this.wwg = wwg;
    }

    @Override
    public void selected(SelectEvent event) {
	if (wwg.isEnabled()) {
	    if (event.getEventAction().equals(SelectEvent.ROLLOVER)) {
		highlight(event.getTopObject());
	    }
	}
    }

    private void highlight(Object obj) {
	if (icon == obj)
	    return;
	if (icon != null) {
	    icon.setHighlighted(false);
	    icon = null;
	}
	if (obj != null && obj instanceof WWIcon) {
	    icon = (WWIcon) obj;
	    icon.setHighlighted(true);
	}
    }
}
