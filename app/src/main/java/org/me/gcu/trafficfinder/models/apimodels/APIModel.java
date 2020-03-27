//Name: Katie King
//Matriculation No.: S1827986
//API model class, calls the channel and the input from the Async task call input method.
//made 26/03/2020

package org.me.gcu.trafficfinder.models.apimodels;

public class APIModel {
    private Channel channel;
    private AsyncTaskCallInput input;


    public APIModel(Channel channel, AsyncTaskCallInput input) {
        this.channel = channel;
        this.input = input;
    }


    public AsyncTaskCallInput getInput() {
        return input;
    }

    public void setInput(AsyncTaskCallInput input) {
        this.input = input;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
