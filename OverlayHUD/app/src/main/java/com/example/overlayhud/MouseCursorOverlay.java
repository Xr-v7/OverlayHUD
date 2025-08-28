package com.example.overlayhud;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Esta clase dibuja el puntero en pantalla (círculo blanco con borde).
  * El MousePanelView actualiza la posición del puntero a través de setCursorPos().
   */
   public class MouseCursorOverlay extends View {
       private final Paint paintFill;
           private final Paint paintStroke;

               // Posición actual del cursor (coordenadas absolutas en pantalla)
                   private float cursorX = 600;
                       private float cursorY = 600;

                           // Tamaño del puntero
                               private final float radius = 20f;

                                   public MouseCursorOverlay(Context context) {
                                           super(context);

                                                   paintFill = new Paint(Paint.ANTI_ALIAS_FLAG);
                                                           paintFill.setColor(Color.WHITE);
                                                                   paintFill.setStyle(Paint.Style.FILL);
                                                                           paintFill.setAlpha(200); // semitransparente

                                                                                   paintStroke = new Paint(Paint.ANTI_ALIAS_FLAG);
                                                                                           paintStroke.setColor(Color.BLACK);
                                                                                                   paintStroke.setStyle(Paint.Style.STROKE);
                                                                                                           paintStroke.setStrokeWidth(3f);

                                                                                                                   // Tamaño del overlay: ocupa toda la pantalla, pero solo dibuja el círculo
                                                                                                                           setLayoutParams(new FrameLayout.LayoutParams(
                                                                                                                                           FrameLayout.LayoutParams.MATCH_PARENT,
                                                                                                                                                           FrameLayout.LayoutParams.MATCH_PARENT
                                                                                                                                                                   ));

                                                                                                                                                                           // Puntero siempre encima (nivel más alto del HUD)
                                                                                                                                                                                   setClickable(false);
                                                                                                                                                                                           setFocusable(false);
                                                                                                                                                                                               }

                                                                                                                                                                                                   @Override
                                                                                                                                                                                                       protected void onDraw(Canvas canvas) {
                                                                                                                                                                                                               super.onDraw(canvas);
                                                                                                                                                                                                                       // Dibuja el puntero en la posición actual
                                                                                                                                                                                                                               canvas.drawCircle(cursorX, cursorY, radius, paintFill);
                                                                                                                                                                                                                                       canvas.drawCircle(cursorX, cursorY, radius, paintStroke);
                                                                                                                                                                                                                                           }

                                                                                                                                                                                                                                               /**
                                                                                                                                                                                                                                                    * Actualiza la posición del cursor y repinta.
                                                                                                                                                                                                                                                         */
                                                                                                                                                                                                                                                             public void setCursorPos(float x, float y) {
                                                                                                                                                                                                                                                                     this.cursorX = x;
                                                                                                                                                                                                                                                                             this.cursorY = y;
                                                                                                                                                                                                                                                                                     invalidate(); // forzar redibujo
                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                         }
                                                                                                                                                                                                                                                                                         