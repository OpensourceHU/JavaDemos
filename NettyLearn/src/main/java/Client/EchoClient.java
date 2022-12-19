package Client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;

/**
 * @author OpensourceHU
 * @version V1.0
 * @Description
 * @date 2022/7/15 0:18
 */
public class EchoClient {
  private final String host;
  private final int port;

  public EchoClient(String host, int port) {
    this.host = host;
    this.port = port;
  }

  public static void main(String[] args) throws InterruptedException {
    if (args.length != 2) {
      System.err.println("Usage" + EchoClient.class.getSimpleName() + "<host> <port>");
      return;
    }
    String host = args[0];
    int port = Integer.parseInt(args[1]);
    new EchoClient(host, port).start();
  }

  public void start() throws InterruptedException {
    NioEventLoopGroup group = new NioEventLoopGroup();
    try {
      Bootstrap b = new io.netty.bootstrap.Bootstrap();
      b.group(group).channel(NioSocketChannel.class)
          .remoteAddress(new InetSocketAddress(host, port))
          .handler(new ChannelInitializer<SocketChannel>() {
            public void initChannel(SocketChannel socketChannel) throws Exception {
              socketChannel.pipeline().addLast(new EchoClientHandler());
            }
          });
    } finally {
      group.shutdownGracefully().sync();
    }
  }
}
