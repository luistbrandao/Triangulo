package testetriangulo;

import javax.media.opengl.*;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;
import jogamp.opengl.macosx.cgl.CGL;

public class TesteTriangulo implements GLEventListener {

    @Override
    public void init(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();
        gl.glClearColor(1.0f,1.0f,1.0f,1.0f);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        final GL2 gl = drawable.getGL().getGL2();

        gl.glBegin(GL2.GL_TRIANGLES);
        
        //gl.glClearColorIi(1, 1, 1, 1);
        //gl.glClear(gl.GL_COLOR_BUFFER_BIT);
        //gl.glClearDepth(1);
        gl.glClear(gl.GL_DEPTH_BUFFER_BIT);
        gl.glColor3f(1.0f, 0.0f, 0.0f);
        gl.glVertex2d(0, 0.5);
        gl.glVertex2d(-0.5, -0.5);
        gl.glVertex2d(0.5, -0.5);
        gl.glEnd();
        gl.glFlush();
        
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {

    }

    @Override
    public void dispose(GLAutoDrawable arg0) {

    }

    public static void main(String[] args) {
        final GLProfile gp = GLProfile.get(GLProfile.GL2);
        GLCapabilities cap = new GLCapabilities(gp);

        final GLCanvas gc = new GLCanvas(cap);
        TesteTriangulo jc = new TesteTriangulo();
        gc.addGLEventListener(jc);
        gc.setSize(400, 400);

        final JFrame frame = new JFrame("Teste triângulo vermelho");
        frame.add(gc);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }
}
