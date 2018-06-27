package org.yourorghere;

import com.sun.opengl.util.Animator;
import com.sun.opengl.util.texture.Texture;
import com.sun.opengl.util.texture.TextureIO;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.DoubleBuffer;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

public class ProjectGrafis implements GLEventListener, KeyListener {

    static Texture textureBumi, textureTanah, textureDiskKerak,
            textureDiskMantel, textureKecilMantel, textureBesarMantel,
            textureDiskInti, textureKecilInti, textureBesarInti,
            textureCore, textureGalaxy;
            
            public static void main(String[] args) {
        Frame frame = new Frame("Lapisan Kerak Bumi");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new ProjectGrafis());
        canvas.addKeyListener(new ProjectGrafis());
        frame.add(canvas);
        frame.setSize(640, 480);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        }
        
        public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());

        try {
            textureBumi = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\earth.jpg"), true);
            System.out.println("Texture Bumi ada");
        } catch (IOException e) {
            System.out.println("Texture Bumi tidak ada");
        }

        try {
            textureTanah = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\ground.jpg"), true);
            System.out.println("Texture Tanah ada");
        } catch (IOException e) {
            System.out.println("Texture Tanah tidak ada");
        }

        try {
            textureDiskKerak = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\disk_kerak.jpg"), true);
            System.out.println("Texture Disk Kerak ada");
        } catch (IOException e) {
            System.out.println("Texture Disk Kerak tidak ada");
        }

        try {
            textureDiskMantel = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\disk_mantel.jpg"), true);
            System.out.println("Texture Disk Mantel ada");
        } catch (IOException e) {
            System.out.println("Texture Disk Mantel tidak ada");
        }

        try {
            textureKecilMantel = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\kecil_mantel.jpg"), true);
            System.out.println("Texture Kecil Mantel ada");
        } catch (IOException e) {
            System.out.println("Texture Kecil Mantel tidak ada");
        }

        try {
            textureBesarMantel = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\besar_mantel.jpg"), true);
            System.out.println("Texture Besar Mantel ada");
        } catch (IOException e) {
            System.out.println("Texture Besar Mantel tidak ada");
        }

        try {
            textureDiskInti = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\disk_inti.jpg"), true);
            System.out.println("Texture Disk Inti ada");
        } catch (IOException e) {
            System.out.println("Texture Disk Inti tidak ada");
        }

        try {
            textureKecilInti = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\kecil_inti.jpg"), true);
            System.out.println("Texture Kecil Inti ada");
        } catch (IOException e) {
            System.out.println("Texture Kecil Inti tidak ada");
        }

        try {
            textureBesarInti = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\besar_inti.jpg"), true);
            System.out.println("Texture Besar Inti ada");
        } catch (IOException e) {
            System.out.println("Texture Besar Inti tidak ada");
        }

        try {
            textureCore = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\core.jpg"), true);
            System.out.println("Texture Core ada");
        } catch (IOException e) {
            System.out.println("Texture Core tidak ada");
        }

        try {
            textureGalaxy = TextureIO.newTexture(
                    new File("C:\\Users\\hunter\\Documents\\NetBeansProjects\\coba\\Texture\\galaxy2.jpg"), true);
            System.out.println("Texture Bintang ada");
        } catch (IOException e) {
            System.out.println("Texture Bintang tidak ada");
        }

        

        // Enable VSync
        gl.setSwapInterval(1);

        // Setup the drawing area and shading mode
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL.GL_SMOOTH); // try setting this to GL_FLAT and see what happens.
    }
    
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (height <= 0) { // avoid a divide by zero error!

            height = 1;
        }
        final float h = (float) width / (float) height;
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 50.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();

        // Clear the drawing area
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        // Reset the current matrix to the "identity"
        gl.glLoadIdentity();
        gl.glEnable(GL.GL_DEPTH_TEST);

        // Move the "drawing cursor" around
        GLU glu = new GLU();
        glu.gluLookAt(C_X, C_Y, C_Z,
                L_X, L_Y, L_Z,
                0, -1, 0);;

        //Auto Rotate Object
        sudut += 1;

        gl.glRotated(90, 1, 0,0 );
        lap_full(gl, 80, 80);
        
        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    static void lap_full(GL gl, int slices, int stacks) {
        gl.glPushMatrix();
        GLU glu = new GLU();
        GLUquadric q = glu.gluNewQuadric();
        double[] eqn = {-1, 0, 0, 0};
        glu.gluQuadricTexture(q, true); // menangkap texture

        //Setengah Bumi
        gl.glClipPlane(GL.GL_CLIP_PLANE0, eqn, 0);
        gl.glEnable(GL.GL_CLIP_PLANE0);
        textureBumi.enable();
        textureBumi.bind();
        glu.gluSphere(q, 2, slices, stacks);
        textureBumi.disable();
        gl.glDisable(GL.GL_CLIP_PLANE0);

        //Disk Kerak Bumi
        gl.glPushMatrix();
        textureDiskKerak.enable();
        textureDiskKerak.bind();
        gl.glColor3f(1, 1f, 1);
        gl.glRotatef(90, 0, 1, 0);
        glu.gluDisk(q, 1.9, 2, slices, stacks);
        gl.glRotatef(-90, 0, 1, 0);
        textureDiskKerak.disable();
        gl.glPopMatrix();

        //Disk Mantel Bumi
        gl.glPushMatrix();
        textureDiskMantel.enable();
        textureDiskMantel.bind();
        gl.glRotatef(90, 0, 1, 0);
        glu.gluDisk(q, 1, 1.9, slices, stacks);
        gl.glRotatef(-90, 0, 1, 0);
        textureDiskMantel.disable();
        gl.glPopMatrix();

        //Disk Inti
        gl.glPushMatrix();
        textureDiskInti.enable();
        textureDiskInti.bind();
        gl.glRotatef(90, 0, 1, 0);
        glu.gluDisk(q, 0.6, 1, slices, stacks);
        gl.glRotatef(-90, 0, 1, 0);
        textureDiskInti.disable();
        gl.glPopMatrix();

        //Setengah Inti
        gl.glPushMatrix();
        gl.glClipPlane(GL.GL_CLIP_PLANE1, eqn, 0);
        gl.glEnable(GL.GL_CLIP_PLANE1);
        textureCore.enable();
        textureCore.bind();
        glu.gluSphere(q, 0.6, slices, stacks);
        textureCore.disable();
        gl.glDisable(GL.GL_CLIP_PLANE1);
        gl.glPopMatrix();

        gl.glPopMatrix();
    }
}
