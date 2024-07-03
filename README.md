# IPAuth

![Latest Release](https://img.shields.io/github/v/release/krystejj/ipauth?include_prereleases&display_name=release&label=Latest%20Release)

> [!NOTE]  
> Fork of original [weisrc's ipauth](https://github.com/weisrc/ipauth) with a few changes from me:
> - mod loader changed from Fabric to Quilt,
> - updated to 1.20.x,
> - auto auth is disabled and use uuid is enabled by default,
> - minor fixes.

A server-side Minecraft Quilt mod that enables per user IP authorization.

## Description

IPAuth adds per user IP based authorization.

This mod is beneficial for offline mode Minecraft servers because it ensures that a user with a username can only join
from a specified IP. This avoids impersonating other users and stealing their resources. It is recommended to use
this mod in conjunction with Minecraft's whitelist enabled and IPAuth's auto auth disabled, this combination would
provide you maximum security.

It is only server-side, there is no need to have it installed client-side. Installing it client-side will give you an
error.

## Commands

- `/ipauth add player` - Register a player without an IP and auto assign it on user's first join.
- `/ipauth add player ip1 ip2 ip3 ...` - Register a player with specified IP addresses the player can join with.
- `/ipauth remove player` - Remove a player from an authorized list.
- `/ipauth remove player ip1 ip2 ip3` - Remove IP addresses the player can join with from an authorized list.
- `/ipauth info` - Get general mod and config information.
- `/ipauth info IP|user` - Get info on an IP or a user.
- `/ipauth setautoauth true|false` - Set auto_auth property from the game.
- `/ipauth setuseuuid true|false` - Set use_uuid property from the game.

## Config

The config is in JSON format and located in `config/ipauth.json`. The config below presents default values and property
descriptions.

```jsonc
{
  auto_auth: false, // on first join, automatically add the user to authorized list with used IP.
  use_uuid: true, // use the uuid instead of using the username to identify the users in the authorized list.
  authorized: {
    "UUID or USERNAME": ["1st IP", "2nd IP", ...]
  }
}
```

## Downloading and Usage

You can download this mod from [releases tab](https://github.com/krystejj/ipauth/releases) in this repository. It works
only server-side with Quilt Loader installed. Put `ipauth-x.x.x+x.x.x.jar` mod file in `mods` folder in your server
directory.

## License

This mod is licensed under MIT, free and open source license. For more info, check the [license file](./LICENSE.md).
