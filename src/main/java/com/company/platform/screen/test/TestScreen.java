package com.company.platform.screen.test;

import io.jmix.core.DataManager;
import io.jmix.ui.component.FileStorageUploadField;
import io.jmix.ui.component.Label;
import io.jmix.ui.component.SingleFileUploadField;
import io.jmix.ui.component.TextField;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import io.jmix.ui.upload.TemporaryStorage;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

@UiController("TestScreen")
@UiDescriptor("Test-screen.xml")
public class TestScreen extends Screen {
    @Autowired
    private FileStorageUploadField uploadTest;
    @Autowired
    private TemporaryStorage temporaryStorage;
    @Autowired
    private TextField pythonCmd;
    @Autowired
    private Label lblResult;

//    @Autowired
//    private ComboBox<Integer> comboFileNo;

    @Subscribe("uploadTest")
    public void onUploadTestFileUploadSucceed(final SingleFileUploadField.FileUploadSucceedEvent event) {
        File file = temporaryStorage.getFile(uploadTest.getFileId());
        String  strResult="";

        try {
            String strCommand = pythonCmd.getValue()+" output.py";
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream("output.py");

            // 创建一个缓冲区
            byte[] buffer = new byte[1024];
            int bytesRead;

            // 将文件流中的数据读取到缓冲区中，并写入文件
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            Process proc=Runtime.getRuntime().exec(strCommand.split(" "));
            InputStreamReader stdin=new InputStreamReader(proc.getInputStream(), "gbk");//
            LineNumberReader input=new LineNumberReader(stdin);

            while (true){
                String printLine = input.readLine();
                if(printLine==null)
                    break;

                strResult+=printLine;
            }
            if(strResult.length()==0){
                BufferedReader errorInfo = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
                while (true){
                    String printLine = errorInfo.readLine();
                    if(printLine==null)
                        break;

                    strResult+=printLine;
                }
            }
            lblResult.setValue(strResult);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}