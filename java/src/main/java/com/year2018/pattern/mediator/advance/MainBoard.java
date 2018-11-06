package com.year2018.pattern.mediator.advance;


/**
 * author：zyh
 * on: 2018/8/22 21:50
 */
public class MainBoard extends Mediator {
    private CDDevice cdDevice;
    private CPU cpu;
    private SoundCard soundCard;
    private GraphicsCard graphicsCard;

    @Override
    public void changed(Colleague c) {
        if(c == cdDevice){
            handleCD((CDDevice)c);
        }else if(c==cpu){
            handleCPU((CPU)c);
        }
    }

    /**
     * 处理光驱读取数据后与其它设备的交互
     * @param cdDevice
     */
    private void handleCD(CDDevice cdDevice){
        cpu.decodeData(cdDevice.read());
    }

    /**
     * 处理CPU读取数据后与其它设备的交互
     * @param cpu
     */
    private void handleCPU(CPU cpu){
        soundCard.soundPlay(cpu.getDataSound());
        graphicsCard.videoPlay(cpu.getDataVideo());
    }

    /**
     * 设置CD设备
     * @param cdDevice
     */
    public void setCDDevice(CDDevice cdDevice){
        this.cdDevice = cdDevice;
    }

    /**
     * 设置CPU
     * @param cpu
     */
    public void setCPU(CPU cpu){
        this.cpu = cpu;
    }

    /**
     * 设置声卡设备
     * @param soundCard 声卡设备
     */
    public void setSoundCard(SoundCard soundCard){
        this.soundCard = soundCard;
    }

    /**
     * 设置显卡设备
     * @param graphicsCard 显卡设备
     */
    public void setGraphicsCard(GraphicsCard graphicsCard){
        this.graphicsCard = graphicsCard;
    }
}
