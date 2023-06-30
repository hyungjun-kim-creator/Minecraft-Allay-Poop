package org.hjun.plugin.allaypoop;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.logging.Logger;

import static org.bukkit.Bukkit.getServer;
import static org.hjun.plugin.allaypoop.AllayPoop.allaypoop;

public class apcommand implements CommandExecutor {
    Logger logger = getServer().getLogger();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equals("allaypoop")) {
            if (sender instanceof Player) {
                if (args[0].equals("status")) {
                    if (args.length == 1) {
                        if (allaypoop == 1) {
                            sender.sendMessage("현재 알레이가 플레이어에게 똥만 줍니다.");
                        } else if (allaypoop == 0) {
                            sender.sendMessage("현재 알레이가 플레이어에게 똥을 주지 않습니다.");
                        }
                    } else if (sender.isOp()) {
                        if (args[0].equals("true")) {
                            allaypoop = 1;
                            sender.sendMessage("지금부터 알레이가 플레이어에게 똥만 줍니다.");
                        } else if (args[0].equals("false")) {
                            allaypoop = 0;
                            sender.sendMessage("지금부터 알레이가 플레이어에게 똥을 주지 않습니다.");
                        } else {
                            sender.sendMessage("명령어 입력이 잘못되었습니다.");
                            sender.sendMessage("§e/" + label + " help §f도움말을 표시합니다.");
                        }
                    } else if (sender.isOp() == false) {
                        sender.sendMessage("관리자 권한(op)가 없어서 해당 명령어 입력이 불가능합니다.");
                    }
                }
                else {
                    sender.sendMessage("명령어 입력이 잘못되었습니다.");
                    sender.sendMessage("§e/" + label + " help §f도움말을 표시합니다.");
                }
            }
            else {
                if (args[0].equals("status")) {
                    if (args.length == 1) {
                        if (allaypoop == 1) {
                            logger.info("현재 알레이가 플레이어에게 똥만 줍니다.");
                        } else if (allaypoop == 0) {
                            logger.info("현재 알레이가 플레이어에게 똥을 주지 않습니다.");
                        }
                    }
                    if (args[0].equals("true")) {
                        allaypoop = 1;
                        logger.info("지금부터 알레이가 플레이어에게 똥만 줍니다.");
                    } else if (args[0].equals("false")) {
                        allaypoop = 0;
                        logger.info("지금부터 알레이가 플레이어에게 똥을 주지 않습니다.");
                    }
                    else {
                        logger.info("명령어 입력이 잘못되었습니다.");
                    }
                }
            }
        }
        return false;
    }
}
