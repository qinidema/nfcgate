package tud.seemuh.nfcgate.network;

import com.google.protobuf.Message;
import tud.seemuh.nfcgate.network.meta.MetaMessage.Wrapper.MessageCase;

public interface HighLevelNetworkHandler {
    // TODO Make sendMessage function private and change all uses to use the utility funct instead
    public void sendMessage(Message msg, MessageCase mcase);

    // Setup
    public HighLevelNetworkHandler connect(String addr, int port);

    // Session messages
    public void createSession();

    public void joinSession(String secret);

    public void leaveSession(String secret);

    // NFC messages
    public void sendAPDUMessage(byte[] apdu);

    public void sendAPDUReply(byte[] reply);

    // Notification messages
    public void notifyReaderFound();

    public void notifyCardFound();

    public void notifyReaderRemoved();

    public void notifyCardRemoved();

    // Error messages
    public void notifyInvalidMsgFormat();

    public void notifyNotImplemented();

    public void notifyUnknownMessageType();

    public void notifyUnknownError();

    public void notifyNFCNotConnected();

    // Misc Messages
    public void sendKeepaliveMessage();

    public void sendKeepaliveReply();
}
