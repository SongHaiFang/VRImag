package demo.song.com.vrimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private VrPanoramaView mPanViewVr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        load360Image();
    }
    /**
     * 加载360度全景图片
     */
    private void load360Image() {
        /**获取assets文件夹下的图片**/

        InputStream open = null;
        try {

            open =getResources().openRawResource(R.raw.vr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(open);
        /**设置加载VR图片的相关设置**/
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_MONO;
        /**设置加载VR图片监听**/
        mPanViewVr.setEventListener(new VrPanoramaEventListener() {
            /**
             * 显示模式改变回调
             * 1.默认
             * 2.全屏模式
             * 3.VR观看模式，即横屏分屏模式
             * @param newDisplayMode 模式
             */
            @Override
            public void onDisplayModeChanged(int newDisplayMode) {
                super.onDisplayModeChanged(newDisplayMode);
            }

            /**
             * 加载VR图片失败回调
             * @param errorMessage
             */
            @Override
            public void onLoadError(String errorMessage) {
                super.onLoadError(errorMessage);
            }

            /**
             * 加载VR图片成功回调
             */
            @Override
            public void onLoadSuccess() {
                super.onLoadSuccess();
            }

            /**
             * 点击VR图片回调
             */
            @Override
            public void onClick() {
                super.onClick();
            }
        });
        /**加载VR图片**/
        mPanViewVr.loadImageFromBitmap(bitmap, options);
    }

    private void initView() {
        mPanViewVr = (VrPanoramaView) findViewById(R.id.vr_pan_view);
    }
}
