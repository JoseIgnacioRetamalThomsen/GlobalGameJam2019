package davidneilan.com;

import org.newdawn.slick.*;

public class Explosion1   {

    public Animation anim;

    public Explosion1(){
        SpriteSheet sprite = null;
        try {

            sprite = new SpriteSheet(new Image("res/sprites/explosion1Sprite.png"),39,37);

        }catch (SlickException e) {
        e.printStackTrace();
    }
       // anim = new Animation(sprite,500000);
        anim = new Animation();
/*
        for(int j=0;j<2;j++) {
            for (int i = 0; i < 4; i++) {
                anim.addFrame(sprite.getSubImage(i,j),500);
            }

        }*/
        anim.addFrame(sprite.getSubImage(0,0),200);
        anim.addFrame(sprite.getSubImage(1,0),100);
        anim.addFrame(sprite.getSubImage(2,0),100);
        anim.addFrame(sprite.getSubImage(3,0),100);
        anim.addFrame(sprite.getSubImage(0,1),100);
        anim.addFrame(sprite.getSubImage(0,1),100);
        anim.addFrame(sprite.getSubImage(1,1),100);
        anim.addFrame(sprite.getSubImage(2,1),150);
        anim.addFrame(sprite.getSubImage(3,1),2000);
      //  anim.addFrame(sprite.getSubImage(1,0),1);
       // anim.getCurrentFrame().setImageColor((float) 4, (float) 3 ,(float)3);
        anim.setPingPong(false);
        //anim.addFrame(100,1,1);
       // anim.addFrame(1,0,1);
        //anim.draw(150,150);
      // anim.start();
    }

    public void draw(){
        anim.draw(100,100);
    }
}
