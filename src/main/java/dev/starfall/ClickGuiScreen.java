package dev.starfall;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

public class ClickGuiScreen extends Screen {
    private boolean storage = false, spawners = false;
    private float opacity = 0.75f;
    private int accent = 0xFF8B5CF6;
    protected ClickGuiScreen() { super(Component.literal("Starfall")); }
    @Override public void render(GuiGraphics g, int mx, int my, float dt) {
        renderBackground(g, mx, my, dt);
        int w=360, h=260, x=(width-w)/2, y=(height-h)/2;
        g.fill(x,y,x+w,y+h,0xEE111318);
        g.fill(x,y,x+w,y+32,0xFF1B1D25);
        g.drawString(font,"STARFALL",x+14,y+12,accent,false);
        g.drawString(font,"VISUAL MODULES",x+16,y+50,0xFFB5B8C5,false);
        g.fill(x+14,y+68,x+w-14,y+69,0xFF343743);
        drawToggle(g,x+18,y+86,"StorageFinder",storage);
        drawToggle(g,x+18,y+116,"SpawnerFinder",spawners);
        g.drawString(font,"Outline opacity (framework demo)",x+18,y+154,0xFFE2E4EA,false);
        g.fill(x+18,y+174,x+w-18,y+180,0xFF343743);
        int knob=x+18+(int)((w-36)*opacity);
        g.fill(x+18,y+174,knob,y+180,accent);
        g.fill(knob-3,y+171,knob+3,y+183,0xFFFFFFFF);
        g.drawString(font,"Click modules to toggle · click slider to adjust",x+18,y+210,0xFF9296A4,false);
        g.drawString(font,"Right Shift to close",x+18,y+232,0xFF9296A4,false);
        super.render(g,mx,my,dt);
    }
    private void drawToggle(GuiGraphics g,int x,int y,String label,boolean on) {
        g.drawString(font,label,x,y,0xFFE2E4EA,false);
        int color=on?accent:0xFF424550;
        g.fill(x+220,y-2,x+270,y+12,color);
        g.drawString(font,on?"ON":"OFF",x+232,y+1,0xFFFFFFFF,false);
    }
    @Override public boolean mouseClicked(net.minecraft.client.input.MouseButtonEvent e, boolean doubleClick) {
        int x=(width-360)/2, y=(height-260)/2;
        if(e.x()>=x+18 && e.x()<=x+288 && e.y()>=y+86 && e.y()<=y+102) storage=!storage;
        else if(e.x()>=x+18 && e.x()<=x+288 && e.y()>=y+116 && e.y()<=y+132) spawners=!spawners;
        else if(e.y()>=y+171 && e.y()<=y+183) opacity=Math.max(0,Math.min(1,(float)(e.x()-x-18)/324f));
        return true;
    }
    @Override public boolean keyPressed(net.minecraft.client.input.KeyEvent e) {
        if(e.key()==GLFW.GLFW_KEY_RIGHT_SHIFT || e.key()==GLFW.GLFW_KEY_ESCAPE){ Minecraft.getInstance().setScreen(null); return true; }
        return super.keyPressed(e);
    }
    @Override public boolean isPauseScreen(){ return false; }
}
