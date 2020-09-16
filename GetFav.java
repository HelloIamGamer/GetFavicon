package com.extension.GetFavTool.xoma;


import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.AndroidViewComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.EventDispatcher;

@DesignerComponent(version = 1,
        category = ComponentCategory.EXTENSION,
        description = "Get high resoultion favicon images from websites, made my Kumaraswamy (Xoma)!",
        nonVisible = true,
        iconName = "https://community.appinventor.mit.edu/user_avatar/community.appinventor.mit.edu/kumaraswamy_b.g/32/13770_2.png")

@SimpleObject(external = true)

public class GetFav extends AndroidNonvisibleComponent {

    public GetFav (ComponentContainer container) {
        super(container.$form());
    }

    @SimpleFunction(description = "Get favicon image, takes time to get image if the internet speed is slow.")
    public void GetFav (String value) {
        try {
            String best = "http://logo.clearbit.com/" + value;
            String good = "http://www.google.com/s2/favicons?domain_url=" + value;
            GotImage(best, good);
        }
        catch(Exception error) {
            ErrorOccured(String.valueOf(error));
        }
    }



    @SimpleEvent(description = "Triggered after the image link is got.")
    public void GotImage(String best, String normal) {
        EventDispatcher.dispatchEvent(this, "GotImage", best, normal);
    }

    @SimpleEvent(description = "Triggered when error occured while getting image..")
    public void ErrorOccured(String error) {
        EventDispatcher.dispatchEvent(this, "ErrorOccured", error);
    }

}
