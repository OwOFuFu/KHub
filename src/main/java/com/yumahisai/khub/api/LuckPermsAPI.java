package com.yumahisai.khub.api;


import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public class LuckPermsAPI {

    public LuckPerms api = LuckPermsProvider.get();

    public User user(Player player){
        return api.getPlayerAdapter(Player.class).getUser(player);
    }

    public User getUser(UUID uniqueId) {
        UserManager userManager = api.getUserManager();
        CompletableFuture<User> userFuture = userManager.loadUser(uniqueId);

        return userFuture.join();
    }

    public boolean isGroup(UUID uniqueId, String group) {
        User user = (User) api.getUserManager().loadUser(uniqueId);

        Collection<Group> inheritedGroups = user.getInheritedGroups(user.getQueryOptions());
        return inheritedGroups.stream().anyMatch(g -> g.getName().equals(group));
    }

    public void addPermission(User user, String permission) {

        user.data().add(Node.builder(permission).build());

        api.getUserManager().saveUser(user);
    }

    public boolean hasPermission(User user, String permission) {
        return user.getCachedData().getPermissionData().checkPermission(permission).asBoolean();
    }


    public String getPrefixGroup(Player player){
        return api.getGroupManager().getGroup(api.getUserManager().getUser(player.getUniqueId()).getPrimaryGroup()).getCachedData().getMetaData().getPrefix();
    }

    public User getUser(Player player){
       return api.getPlayerAdapter(Player.class).getUser(player);
    }

}
